"use client";
import React, { useState } from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";
import axios from "axios";
import { TextEncoder } from "text-encoding";
import Image from 'next/image'


const FILE_SIZE = 1024 * 1024 * 5; //5MB
const SUPPORTED_FORMATS = ["image/jpg", "image/jpeg", "image/gif", "image/png"];

const uploadImage = async (values) => {
  // setIsLoading(true);
  try {
    const response = await axios.post(
      "https://api.escuelajs.co/api/v1/files/upload",
      values.file
    );
    console.log(response);
    return (
      response?.data?.location ||
      "https://sumansourabh.in/wp-content/uploads/2021/11/sanemi-hashira-meeting-1024x577.webp"
    );
  } catch (error) {
    console.log(error);
  }
};
const validationSchema = Yup.object().shape({
  name: Yup.string().required("Required"),
  email: Yup.string().email("Invalid email").required("Required"),
  password: Yup.string()
    .min(6, "Password must be 8 characters")
    .max(15, "Password too long")
    .required("Required"),
  confirmPassword: Yup.string()
    .oneOf([Yup.ref("password"), null], "Password must match")
    .required("Required"),
  file: Yup.mixed()
    .test("fileSize", "File too large", (value) => {
      if (!value) {
        return true;
      }
      return value.size <= FILE_SIZE;
    })
    .test("fileFormat", "unsupported Format", (value) => {
      if (!value) {
        return true;
      }
      return SUPPORTED_FORMATS.includes(value.type);
    })
    .required("reqired"),
});
export default function login() {
  const createUser = async (user) => {
    const { name, email, password, role, avatar } = user;
    let myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    let raw = JSON.stringify({
      name,
      email,
      password,
      role,
      avatar,
    });

    let requestOptions = {
      method: "POST",
      headers: myHeaders,
      body: raw,
    };

    try {
      const res = await fetch(
        "https://api.escuelajs.co/api/v1/users",
        requestOptions
      );
      // if(!res.ok) throw new Error("Error in fetch")
      if (!res.ok) {
        alert("something went wrong");
      } else {
        alert("User create successfully");
        const data = await res.json();
        return data;
      }
    } catch (err) {
      console.log(err);
      alert(err.meessage);
    }
    // .then(response => response.json())
    // .then(result => {
    // console.log("user reponse",result);
    // alert("user create successfully")
    //   if(result.error){
    //     alert(result.message);
    //   }else{
    //     alert("user create successfully")
    //     console.log(result);
    //   }
    // })
    // .catch(error =>{
    //   console.log('error', error);
    //   alert(error.message);
    // }
    // );
  };

  // "email": "limhaifc@gmail.com",
  // "name": "limhai",
  // "password": "172212",
  // "role": "customer",
  // "avatar": "https://1.bp.blogspot.com/-vN_zdOIWtHI/X5kbQkhjW7I/AAAAAAAAH_w/c2kQLo2QR8A6btSibKrrUxKyrkvZaO8ggCLcBGAsYHQ/s790/Sanemi.PNG"
  return (
    <div className="max-w-md mx-auto">
    <div
      className="my-60 container  "
      style={{
        marginLeft: "200px",
        border: "3px solid black",
        borderRadius: "9px",
      }}
    >
    <div className="">
    <Formik 
        initialValues={{
          name: "",
          email: "",
          password: "",
          confirmPassword: "",
          role: "customer",
          file: undefined,
        }}
        validationSchema={validationSchema}
        onSubmit={async (values, { setSubmitting, resetForm }) => {
          // setTimeout(async() => {

          // }, 500)
          // const data =  await createUser(values);
          //   setSubmitting(false);
          const formData = new FormData();
          formData.append("file", values.file);
          const avatar = await uploadImage({ file: formData });
          console.log("avatar", avatar);

          values.avatar = avatar;

          createUser(values);
          setSubmitting(false);

          resetForm();
        }}
      >
        {({ isSubmitting, setFieldValue }) => (
          <div>
          <Form>
            {/* name */}
            <div className="mb-3 ml-6 mt-6 mr-6">
              <label className="block mb-2 text-sm font-medium text-gray-900 dark:text-slate-800">
                {" "}
                Enter your name
              </label>
              <Field
                type="text"
                name="name"
                placeholder="Name"
                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              />
              <ErrorMessage
                name="name"
                component="div"
                className="invalid-feedback"
              />
            </div>

            {/* email */}
            <div className="mb-6 ml-6 mt-6 mr-6">
              <label className="block mb-2 text-sm font-medium text-gray-900 dark:text-slate-800">
                {" "}
                Enter your email
              </label>
              <Field
                type="email"
                name="email"
                placeholder="email"
                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              />
              <ErrorMessage
                name="email"
                component="div"
                className="invalid-feedback"
              />
            </div>

            {/* password */}
            <div className="mb-6 ml-6 mt-6 mr-6">
              <label
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-slate-800"
                htmlFor="password"
              >
                {" "}
                Enter your password
              </label>
              <Field
                type="password"
                name="password"
                placeholder="password"
                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              />
              <ErrorMessage
                name="password"
                component="div"
                className="invalid-feedback"
              />
            </div>

            {/* confirm password */}
            <div className="mb-6 ml-6 mt-6 mr-6">
              <label
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-slate-800"
                htmlFor="confirmPassword"
              >
                {" "}
                Enter your confirm password
              </label>
              <Field
                type="password"
                name="confirmPassword"
                placeholder="confirm password"
                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              />
              <ErrorMessage
                name="confirmPassword"
                component="div"
                className="invalid-feedback"
              />
            </div>
            {/* avatar */}
            <div className="mb-6 ml-6 mt-6 mr-6">
              <Field
                name="file"
                type="file"
                title="select a file"
                setFieldValue={setFieldValue} //set formik value
                component={CustomInput} // component prop used to redar the custom input
              />
              <ErrorMessage name="file">
                {(msg) => <div className="text-danger">{msg}</div>}
              </ErrorMessage>
            </div>

            {/* submit */}
            <div className="ml-36 mb-9" style={{ }}>
              <button
                type="submit"
                disabled={isSubmitting}
                className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
              >
                Submit
              </button>
            </div>
          </Form>
          </div>
        
        )}
      </Formik>
    </div>
  
    </div>
    </div>

  );
}
function CustomInput({ field, form, ...props }) {
  const [perview, setPreview] = useState(null);
  return (
    <div>
      <input
        type="file"
        onChange={(event) => {
          form.setFieldValue(field.name, event.currentTarget.files[0]);
          setPreview(URL.createObjectURL(event.currentTarget.files[0]));
          console.log(event.currentTarget.files[0]);
        }}
        {...props}
      />
      {perview && (
        <img
          className="w-80 h-48 founded-full object-cover"
          src={perview}
          alt="perview"
        />
      )}
    </div>
  );setPreview
}
