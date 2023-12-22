import React from "react"
 import Button from 'react-bootstrap/Button';

const Btn = ({title,btnStyle})=>{
    const defaultStyle ="btn btn-primary"
    const defualtTitle ="click me"
  return (
    <Button id="btnc" className={btnStyle?btnStyle: defaultStyle}>
        {title?title:defualtTitle}
    </Button>
  )
}
export default Btn
