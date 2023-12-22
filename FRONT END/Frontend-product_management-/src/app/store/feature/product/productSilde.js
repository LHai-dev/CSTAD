import {createSlice} from "@reduxjs/toolkit";

const productSilde = createSlice({
    name: 'product',
    initialState: {
        product: null,
        category: [],
        isLoading: true,
        duplicate: null
    },
});