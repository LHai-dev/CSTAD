import React from 'react'
import Image from 'next/image'

export default function UserDetail({id,email,name,role,avatar,creationAt,updatedAt,message}) {
  return (
    <>
    <div className=''>
    <div className="card text-center">
  <div className="card-header">
    {role}
  </div>
  <div className="card-body">
  <div className='d-flex justify-center'><img alt="limhai.png" src={avatar}/></div>
  
    <h5 className="card-title">{name}</h5>
    <p className="card-text">{email}</p>
    <h1 className=''>{id}</h1>
    <h6>{message}</h6>
  </div>
  <div className="card-footer text-muted"><strong>CreateTime:</strong>
   {creationAt}
  </div>
</div>
    </div>

    </>
  )
}
