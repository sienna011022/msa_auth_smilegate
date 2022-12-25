import { createSlice } from '@reduxjs/toolkit';

export const TOKEN_TIME_OUT = 600*1000;

export const tokenSlice = createSlice({
    name: 'authToken',
    initialState: {
        authenticated: false, //현재 로그인 여부를 간단히 확인
        accessToken: null, // access token 저장
        expireTime: null  // access token 만료 시간
    },
    reducers: {
        //access token 저장
        SET_TOKEN: (state, action) => {
            state.authenticated = true;
            state.accessToken = action.payload;
            state.expireTime = new Date().getTime() + TOKEN_TIME_OUT;
        },
        DELETE_TOKEN: (state) => {
            state.authenticated = false;
            state.accessToken = null;
            state.expireTime = null
        },
    }
})

export const { SET_TOKEN, DELETE_TOKEN } = tokenSlice.actions;

export default tokenSlice.reducer;
