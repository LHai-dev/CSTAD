import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

function BasicExample() {
  return (
    <Card style={{ width: '18rem' }}>
      <Card.Img variant="top" src="https://www.apple.com/v/homepod-2nd-generation/a/images/overview/homepod_twins__gi5qodweaqie_large.jpg" />
      <Card.Body>
        <Card.Title>HomePod</Card.Title>
        <Card.Text>
        Create a stereo pair to amplify all the music you love.3
        </Card.Text>
        <Button className='buu' variant="primary">Buy Now</Button>
      </Card.Body>
    </Card>
  );
}

export default BasicExample;