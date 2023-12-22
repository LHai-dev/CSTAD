"use client"
import React, { useEffect, useState } from 'react';
import { Formik, Form, Field, ErrorMessage } from 'formik';
import axios from "axios";
import LoadingSubmit from "@/components/LoadingSubmit";
import * as Yup from "yup";
import Image from "next/image";


const FILE_SIZE = 1024 * 1024 * 2; //5MB
const SUPPORTED_FORMATS = ["image/jpg", "image/jpeg", "image/gif", "image/png"];

const validationSchema = Yup.object().shape({
    title: Yup.string().required("The title is required."),
    price: Yup.string().required("The price is required."),
    categoryId: Yup.string().required("The category is required."),
    description: Yup.string().required("The description is required."),
    file: Yup.mixed()
        .test("fileFormat", "Unsupported Format", (value) => {
            if (!value) {
                return true;
            }
            return SUPPORTED_FORMATS.includes(value.type);
        })
        .test("fileSize", "File too large", (value) => {

            if (!value) {
                return true;
            }
            return value.size <= FILE_SIZE;
        }).required("File Required")

})

function Product() {
    const [previewImage, setPreviewImage] = useState("");
    const [isLoading, setIsLoading] = useState(false);
    const [imageURL, setImageURL] = useState("");
    const CreateProduct = async (product) => {
        console.log("b4",product)
        product.images= [
            product.file
        ]
        const { title, price, categoryId, description, images } = product;
        const myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");

        let raw = JSON.stringify({
            title,
            price,
            categoryId,
            description,
            images,
        });
        // console.log("product raw",raw);
        let requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: raw,
        };

        try {
            const res = await fetch("https://api.escuelajs.co/api/v1/products", requestOptions)
            if (!res.ok) {
                alert("Something Went Wrong")
                // console.log(res)
            } else {
                alert("User create Successfully")
                // console.log("User create Successfully")
                const data = await res.json();
                return data;
            }
        } catch (err) {
            console.log(err)
        }
    };



    const uploadImage = async (values) => {

        try {
            const response = await axios.post(
                "https://api.escuelajs.co/api/v1/files/upload",
                values.file
            );
            console.log(response);
            setIsLoading(false);
            return response?.data?.location || "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcThyEKIq_a7eWEwVEoo1aTBQ6gV1KQ4BI8ojEQgnl0ITQ&s";
        } catch (error) {
            console.log(error);
        }
    }

    return (
        <div className="my-24 w-screen flex flex-col items-center justify-center">
            <Formik initialValues={{
                title: '',
                price: '',
                categoryId: '',
                description: '',
                file: undefined
            }}
                    validationSchema={validationSchema}
                    onSubmit={async (values, { setSubmitting, resetForm }) => {
                        setIsLoading(true)
                        const formData = new FormData();
                        formData.append("file", values.file);

                        const avatar = await uploadImage({ file: formData });
                        values.file = avatar


                        // createUser(values);

                        const data = await CreateProduct(values)
                        console.log(data)
                        setSubmitting(false);
                        resetForm();
                    }}>
                {({ isSubmitting, setFieldValue }) => (
                    <Form>
                        {/* Name */}

                        <div className="relative z-0 w-full mb-3 group">

                            <Field type="text" name="title" id="float_title"
                                   className="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-dark dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer"
                                   placeholder=" " />
                            <label htmlFor="float_title"
                                   className="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:left-0 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">
                                Title
                            </label>
                            <ErrorMessage name="title" component="div" className="text-red-500"/>
                        </div>
                        {/*Name End*/}

                        {/* Price */}
                        <div className="relative z-0 w-full mb-6 group">
                            <Field type="number" name="price" id="price"
                                   className="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-dark dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer"
                                   placeholder=" " />
                            <label htmlFor="price"
                                   className="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:left-0 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">
                               Price
                            </label>
                            <ErrorMessage name="price" component="div" className="text-red-500" />
                        </div>
                        {/*Price End*/}

                        {/* Category */}
                        <div className="relative z-0 w-full mb-6 group">
                            <Field type="number" name="categoryId" id="category"
                                   className="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-dark dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer"
                                   placeholder=" " />
                            <label htmlFor = "category"
                                   className="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:left-0 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">
                                categoryID
                            </label>
                            <ErrorMessage name="categoryId" component="div" className="text-red-500" />
                        </div>
                        {/*Password End*/}

                        {/* ConfirmPassword */}
                        <div className="relative z-0 w-full mb-6 group">
                            <Field type="text" name="description" id="description"
                                   className="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-dark dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer"
                                   placeholder=" " />
                            <label htmlFor="description"
                                   className="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:left-0 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">
                                Description
                            </label>
                            <ErrorMessage name="description" component="div" className="text-red-500" />
                        </div>
                        {/* ConfirmPassword End*/}

                        {/* Avatar */}
                        <div className="relative z-0 w-full mb-6 group">
                            <Field
                                setSubmitting={isSubmitting}
                                type="file"
                                name="file"
                                title="Select a file"
                                setFieldValue={setFieldValue} // Set Formik value
                                component={CustomInput} // component prop used to render the custom input
                            />
                            <ErrorMessage name="file" component="div" className="text-red-500" />
                        </div>

                        {/* Avatar End*/}
                        <div className="  flex flex-col items-center justify-center">
                            <button type="submit" disabled={isSubmitting}
                                    className="text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:outline-none focus:ring-red-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-red-600-600 dark:hover:bg-red-700 dark:focus:ring-red-700-800">
                                <div className="flex flex-row "> Submit {isLoading ? <LoadingSubmit /> : ""}</div>
                            </button>

                        </div>
                    </Form>
                )}
            </Formik>
        </div>
    )
}

function CustomInput({ field, form, setSubmitting, ...props }) {
    const [previewImage, setPreviewImage] = useState(null);
    useEffect(() => {
        if (setSubmitting) {
            setPreviewImage(null)
        }
    }, [setSubmitting])
    const handleChange = (event) => {
        const file = event.currentTarget.files[0];
        form.setFieldValue(field.name, file);
        setPreviewImage(URL.createObjectURL(file));
    };

    return (
        <>
            <div className="flex items-center justify-center w-full">

                <label htmlFor="dropzone-file"
                       className="flex flex-col items-center justify-center w-full h-64 border-2 border-gray-300 border-dashed rounded-lg cursor-pointer bg-gray-50 dark:hover:bg-bray-800 dark:bg-gray-700 hover:bg-gray-100 dark:border-gray-600 dark:hover:border-gray-500 dark:hover:bg-gray-600">
                    <div className="flex flex-col items-center justify-center pt-5 pb-6">

                        {previewImage && (
                            <img  width={500} height={500} src={previewImage} alt="preview" className="mt-4 h-20 w-20" />
                        )}
                    </div>
                    <input
                        className=" border border-gray-500 rounded
                            px-4 py-2 block w-full text-sm text-gray-900 border border-gray-300
                            rounded-lg cursor-pointer bg-gray-50 dark:text-gray-400 focus:outline-none
                             dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400"
                        id="dropzone-file" type="file" onChange={handleChange} />

                </label>
            </div>


        </>
    );
}

export default Product;
