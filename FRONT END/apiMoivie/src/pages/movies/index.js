import NavBarComponent from "@/components/NavBarComponent";
import Container from "react-bootstrap/Container";
import {Col, Row} from "react-bootstrap";
import MovieCard from "@/components/MovieCard";
import {API_KEY, BASE_URL, IMAGE_BASE_PATH} from "@/lib";
import MyPlaceHolder from "@/components/MyPlaceholder";

function Movies({movies}) {

    let placeholder =[]
    for (let i=0;i<20;i++){
        placeholder.push(<Col> <MyPlaceHolder /> </Col>)
    }

    return (
        <>
            <Container>
                <Row md={3} lg={5} className={"g-3"}>
                    {movies.legend < 0 ?
                        placeholder
                        :
                        movies.map((m,index) => (
                            <Col key={index}>
                                <MovieCard
                                    image={IMAGE_BASE_PATH + m.poster_path}
                                    title={m.original_title}
                                    overview={m.overview}
                                    id={m.id}
                                />
                            </Col>
                        ))}
                </Row>
            </Container>
        </>
    )
}

export async function getServerSideProps(context) {
    const res = await fetch(`${BASE_URL}/movie/popular?api_key=${API_KEY}&page=1`)
    const movies = await res.json()
    return {
        props: {
            movies: movies.results
        }
    }
}


export default Movies