import {useRouter} from "next/router";
import {useEffect, useState} from "react";
import {API_KEY, BASE_URL, IMAGE_BASE_PATH, No_Image} from "@/lib";
import Container from "react-bootstrap/Container";
import {Badge, Col, Row} from "react-bootstrap";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import WatchTrailer from "@/components/WatchTrailer";

export default function Movie(){
    const router = useRouter()
    const movieId = router.query.id
    const [movie,setMovie] = useState()
    const [videos,setVideos] = useState()
    const [loadVideo, setLoadVideo] = useState(false)
    const [loadMovie, setLoadMovie] = useState(false)

    useEffect(()=>{
        fetch(`${BASE_URL}/movie/${movieId}?api_key=${API_KEY}`)
            .then(res => res.json())
            .then(data => {
                setMovie(data)
                setLoadMovie(true)
            })
        fetch(`${BASE_URL}/movie/${movieId}/videos?api_key=${API_KEY}`)
            .then(res => res.json())
            .then(data => {
                setVideos(data)
                setLoadVideo(true)
            })
    },[])

    let genres = []

    if (loadMovie){
        for (let j=0;j<movie.genres.length;j++){
            genres.push(
                <Badge pill bg="primary">
                    {movie.genres[j].name}
                </Badge>
            )
        }
    }


    return (
        <Container>
            <Row>
                <Col md={4} lg={3}>
                    <Card.Img className="img-thumbnail" variant="top" src={movie?.backdrop_path ? IMAGE_BASE_PATH + movie?.backdrop_path : No_Image} />
                </Col>
                <Col md={8} lg={9}>
                    <Card>
                        <Card.Body>
                            <Card.Title style={{textAlign:'center'}}>{movie?.title}</Card.Title>
                            <div>
                              
                            </div>
                            <Card.Text>
                                <p style={{textAlign:'center'}}>Overview</p>
                                {movie?.overview}
                            </Card.Text>

                            <WatchTrailer
                                embedKey={loadVideo ? videos.results[videos.results.length-1].key : "J1PlHGTa2_o"}
                            />
                        </Card.Body>
                    </Card>
                </Col>
            </Row>
        </Container>
    )
}