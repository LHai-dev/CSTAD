import React from "react";
import UserComponent from "@/components/UserComponent";

export async function getcati() {
  // no-store to avoid cache
  const res = await fetch(
    "https://api.escuelajs.co/api/v1/users?limit=12",
    { cache: "no-store" }
  );
  const data = await res.json();
  return data;
}

export default async function aboutUs() {
  const cati = await getcati();

  return (
    <>
    
      <div className="container  " style={{}}>
          <div style={{textAlign:'center'}}><h1>User</h1></div> 
          <div style={{display:'flex' , justifyContent:'center'}}>
          <div className="container ">
              <div className="row ">
                {cati.map((c) => (
                  <UserComponent
                    key={c.id}
                    id={c.id}
                    title={c.title}
                    avatar={c.avatar}
                    role = {c.role}
                    name={c.name}
                    creationAt={c.creationAt}
                  />
                ))}
              </div>
            </div>
          </div>

          </div>
    </>
  );
}
