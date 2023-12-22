import Link from "next/link";
import Image from 'next/image'

export default function UserHomeComponent({avatar,name,role,id}) {
console.log("in user component: ", id, name, role, avatar)

  return (
    
    <div className="col-sm-4 col-md-6 col-lg-4 items-center">
    <div className="d-flex justify-center">
    <div className="w-52 rounded">
      <img
        
        className="p-8 rounded-t-lg rounded"
        src={avatar ? avatar   : "/images/placeholder-image.png"}
        alt="product image"
      />
      <h2  className="text-center">{name}</h2>
      <p>
        <label className="d-flex justify-center">
          <strong className="">Roles: </strong>
          {role}
        </label>
        
      </p>
   
      <div className="d-flex justify-center">
      <Link className="btn btn-secondary " href={`/user-Detail/${id}`}>
          View details »
        </Link>
      </div>

    </div>
    </div>

    </div>

  );
}
