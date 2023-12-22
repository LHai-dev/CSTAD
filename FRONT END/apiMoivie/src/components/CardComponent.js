import Link from 'next/link';
import React from 'react'
import { Card } from 'react-bootstrap';
import {BASE_PATH} from "@/lib";
import Button from "react-bootstrap/Button";
import {useRouter} from "next/router";


export default function CardComponent({ title,des,imagePath,id}) {
  const router=useRouter();
  const handleClick = () =>{
    router.push(`/movie/${id}`);
  }
  return (
    <>
     <Card className={"h-100"}>
            <div style={{height: '220px'}}>
                <Card.Img variant="top" className="w-100 h-100" style={{objectFit:'cover'}} src={imagePath ? imagePath : ""} />
            </div>
            <Card.Body>
                <Card.Title>{title ? title :"Card Title"}</Card.Title>
                <Card.Text>
                    {des ? des : `Some quick example text to build on the card title and make up the
                    bulk of the card's content.`}
                </Card.Text>
            </Card.Body>
            <Card.Footer>
                <Button size={"sm"} onClick={handleClick} variant="primary">View Detail</Button>
            </Card.Footer>
        </Card>


    </>


  )
}
