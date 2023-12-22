import UserComponent from '@/components/UserComponent';
import UserDetail from '@/components/UserDetail';
import React from 'react'
async function getUserVeiwDetail1(id) {
    const res = await fetch(`https://api.escuelajs.co/api/v1/users/${id}`);
    const data1 = await res.json();
    return data1;
  }
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


