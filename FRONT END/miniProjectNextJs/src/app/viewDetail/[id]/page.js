import ViewDetail from "@/components/ViewDetail";
import React from "react";
async function getUserVeiwDetail(id) {
  const res = await fetch(`https://api.escuelajs.co/api/v1/products/${id}`,{cache: "no-store"});
  console.log(res)
  const data = await res.json();
  return data;
}
export async function getProductDetails(id) {
	const res = await fetch(`https://api.escuelajs.co/api/v1/products/${id}`)
	const data = await res.json()
	return data
}

export async function generateMetadata({ params }) {
	// read route params
	const id = params.id

	// fetch data
	const product = await getProductDetails(id)

	return {
		title: product.title,
		description: product.description,
		image: product.images,
		openGraph: {
			type: "website",

			url: `https://escuelajs.co/product/${id}`,
			title: product.title,
			description: product.description,
			images: [
				{
					url: product.images,
					width: 800,
					height: 600,
				},
			],
		},
	}
}



// export default async function page({ params }) {
//   const { id } = params;
//   const user = await getUserVeiwDetail(id);
//   return {
//     title: user.title,
//     description: user.description,
//     metadataBase: new URL("https://istad.co"),
//     alternates: {
//       canonical: "/", // canonical mean the original page
//       languages: {
//         "en-US": "/en-US",
//         "de-DE": "/de-DE",
//       },
//     },
//     openGraph: {
//       images: user.images[0],
//     },
//   };
// }
export default async function UserDetails({params}){
    const {id} = params;
    const user = await getUserVeiwDetail(id);
    console.log(user);
    return(
            <ViewDetail 
                title = {user.title}
                image = {user.images[0]}
                price = {user.price}
                id = {user.id}  
                description = {user.description}
            />
    )
}
  
// , , , id,