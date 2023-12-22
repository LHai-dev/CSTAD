import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import {No_Image} from "@/lib";
import Link from "next/link";
import NavBarComponent from './NavBarComponent';

function MovieCard({image, title,overview, id}) {
    return (
        <>
            
        <Card className={"h-100"} style={{marginTop:'20px' ,border:'none' ,backgroundColor:'silver'}}>
            <div style={{height: '300px'}}>
                <Card.Img variant="top" className="w-100 h-100" style={{objectFit:'contain'}} src={image ? image : No_Image} />
            </div>
            <Card.Body>
                <Card.Title>{title ? title : "Default title"}</Card.Title>
                <Card.Text>
                    {overview ? overview.substring(0,100) + "..." : "Some quick example text to build on the card title and make up the bulk of the cards content."}
                </Card.Text>
            </Card.Body>
            <Card.Footer style={{justifyContent:"center" , display:'flex'}}>
                <Link href={"/movies/"+ id} className="btn btn-primary btn-sm  "  >View</Link>
            </Card.Footer>
        </Card>
        </>
       
    );
}

export default MovieCard;