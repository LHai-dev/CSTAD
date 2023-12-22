import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import Placeholder from 'react-bootstrap/Placeholder';

export default function MyPlaceHolder(){
    const imgStyle = {
        height: "200px"
    }
    return (
        <Card className={"h-100"}>
            <Placeholder style={imgStyle} />
            <Card.Body>
                <Placeholder as={Card.Title} animation="glow">
                    <Placeholder xs={6} />
                </Placeholder>
                <Placeholder as={Card.Text} animation="glow">
                    <Placeholder xs={12} />
                    <Placeholder xs={9} />
                    <Placeholder xs={8} />
                    <Placeholder xs={6} />
                </Placeholder>
            </Card.Body>
            <Card.Footer>
                <Placeholder.Button className={"btn-sm"} variant="primary" xs={4} />
            </Card.Footer>
        </Card>
    )
}