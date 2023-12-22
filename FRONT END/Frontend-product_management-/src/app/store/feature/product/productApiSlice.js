import {apiSlice} from "@/app/store/api/apiSlice";

export const productApiSlice = apiSlice.injectEndpoints({
    tagType: ["ProductsFeature"],
    endpoints: (build) => ({
        getProduct: builder.query({
            query: ({page, limit, filters}) => ({
                url: "/products",
                params: {
                    page,
                    limit,
                    ...filters
                },
            }),
            keepUnusedDataFor: 5, // keep unused data in cache for 5 seconds
            providesTags: ["product"], // provideTags are used for updating cache
        })
    })
})
export const {
    useGetProductQuery,

} = productApiSlice;