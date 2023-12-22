import CardComponent from "@/components/CardComponent";
import TextDetail from "@/components/TextDetail";
import ShippingPrice from "@/components/ShippingPrice";
import SlideServiceD from "@/components/SlideServiceD";
import CarouselSlideComponent from "@/components/CarouselSlideComponent";
export default  function Home() {
    return (
        <>
            <CarouselSlideComponent/>
            <CardComponent/>
            <TextDetail/>
            <ShippingPrice/>
            <SlideServiceD/>

        </>
    )
}
