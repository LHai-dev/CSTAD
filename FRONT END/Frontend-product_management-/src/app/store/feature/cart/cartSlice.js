import { createSlice } from '@reduxjs/toolkit'
import AlertConponent from "@/components/AlertConponent";
import React from "react";
const initialState = {
  cart: [],
  total: 0
}

const cartSlice = createSlice({
  name: 'cart',
  initialState,
  reducers: {
    addToCart(state, action) {
      const { id, name, price, quantity, image, description } = action.payload
      const existingItem = state.cart.find(item => item.id === id)

      if (existingItem) {
      alert("hello")
      } else {
        state.cart.push({ id, name, price, quantity, image, description })
      }

      state.total += price * quantity
    },
    increaseQuantity(state, action) {
      const { id, price } = action.payload
      const existingItem = state.cart.find(item => item.id === id)

      if (existingItem) {
        existingItem.quantity++
      }
      state.total += price
    },
    decreaseQuantity(state, action) {
      const { id, price } = action.payload
      const existingItem = state.cart.find(item => item.id === id)

      if (existingItem) {
        existingItem.quantity--
      }
      state.total -= price

      if (existingItem.quantity === 0) {
        state.cart = state.cart.filter(item => item.id !== id)
      }
    }

  }
})

// export actions
export const { addToCart, decreaseQuantity, increaseQuantity } = cartSlice.actions

// export reducer
export default cartSlice.reducer

// selectors
export const selectCart = state => state.cart.cart
export const selectTotal = state => state.cart.total
