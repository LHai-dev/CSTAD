'use client'

import React from 'react'
import UserDetail from '@/components/UserDetail';
export default async function page({params}) {
    const {id} = params;
    const user1 = await getUserVeiwDetail1(id);
    console.log(user1)
  return (
    <UserDetail
        id = {user1.id}
        email = {user1.email}
        name = {user1.name}
        role = {user1.role}
        avatar = {user1.avatar}
        creationAt = {user1.creationAt}
        updatedAt = {user1.updatedAt}
        message = {user1.message}
    />
  )
}
