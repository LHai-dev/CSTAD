(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[521],{512:function(e,t,r){(window.__NEXT_P=window.__NEXT_P||[]).push(["/about",function(){return r(3201)}])},8437:function(e,t,r){"use strict";r.d(t,{Z:function(){return Layout}});var a=r(5893),i=r(2023),n=r(7877),o=r(3024),s=r(9603),l=r(9008),d=r.n(l),c=r(1664),h=r.n(c);r(5152);var u=r(7294);function useLocalStorage(e,t){let[r,a]=(0,u.useState)(()=>{try{let r=window.localStorage.getItem(e);return r||t}catch(e){return console.log(e),t}});return[r,t=>{try{let i=t instanceof Function?t(r):t;a(i),window.localStorage.setItem(e,JSON.stringify(i))}catch(e){console.log(e)}}]}function Layout(e){let{children:t}=e,[r,l]=useLocalStorage("theme","light");return(0,u.useEffect)(()=>{"dark"!==localStorage.theme&&("theme"in localStorage||!window.matchMedia("(prefers-color-scheme: dark)").matches)?document.getElementsByTagName("html")[0].classList.remove("dark"):document.getElementsByTagName("html")[0].classList.add("dark")},[]),(0,u.useEffect)(()=>{"dark"==r?(document.getElementsByTagName("html")[0].classList.add("dark"),localStorage.theme="dark"):(document.getElementsByTagName("html")[0].classList.remove("dark"),localStorage.theme="light")},[r]),(0,a.jsxs)("div",{className:"flex flex-col items-center justify-center w-screen h-screen text-gray-800 transition duration-1000 ease-in-out dark:text-white dark:bg-blueGray-700",children:[(0,a.jsxs)(d(),{children:[(0,a.jsx)("title",{children:"Katherine Oelsner"}),(0,a.jsx)("meta",{name:"viewport",content:"initial-scale=1.0, width=device-width"}),(0,a.jsx)("script",{defer:!0,"data-domain":"katherineoelsner.com",src:"https://plausible.io/js/plausible.js"})]}),(0,a.jsxs)("div",{style:{minWidth:"24rem",maxWidth:"37rem"},className:"flex flex-col items-center justify-center w-2/3",children:[(0,a.jsx)("div",{className:"fixed cursor-pointer top-3 right-3",children:(0,a.jsx)(DarkModeToggle,{mode:"dark"==r?"sun":"moon",onClick:()=>{"dark"==r?l("light"):l("dark")},width:"3rem",moonColor:"#334155",sunColor:"white",animationDuration:1})}),(0,a.jsxs)(i.E.div,{layoutId:"nav",className:"flex flex-wrap justify-center leading-6",children:[(0,a.jsx)(h(),{href:"/",children:(0,a.jsx)("button",{className:"w-24 py-1 text-xs leading-6 tracking-widest border border-gray-300 rounded-full dark:hover:border-pink-500 dark:border-white focus:outline-none hover:text-lightBlue-600 hover:border-lightBlue-600 dark:hover:text-pink-500",children:"HOME"})}),(0,a.jsx)(h(),{href:"/about",children:(0,a.jsx)("button",{className:"w-24 py-1 mx-2 text-xs leading-6 tracking-widest border border-gray-300 rounded-full dark:hover:border-pink-500 dark:border-white focus:outline-none hover:text-lightBlue-600 hover:border-lightBlue-600 dark:hover:text-pink-500",children:"ABOUT"})})]}),(0,a.jsx)(i.E.div,{layoutId:"border-div",className:"flex flex-col items-center justify-center w-full py-8 my-6 border-t border-b border-gray-300 dark:border-white",children:(0,a.jsx)(n.M,{exitBeforeEnter:!0,children:t})}),(0,a.jsxs)(i.E.div,{layoutId:"social-icons",className:"flex items-center justify-center",children:[(0,a.jsx)("a",{className:"text-gray-400 dark:text-white hover:text-lightBlue-600 dark:hover:text-pink-500",href:"https://github.com/octokatherine",target:"_blank",children:(0,a.jsx)(s.G,{className:"mr-6 text-2xl ",icon:o.zhw})}),(0,a.jsx)("a",{className:"text-gray-400 dark:text-white hover:text-lightBlue-600 dark:hover:text-pink-500",href:"https://twitter.com/katherinecodes",target:"_blank",children:(0,a.jsx)(s.G,{className:"mr-6 text-2xl",icon:o.mdU})}),(0,a.jsx)("a",{className:"text-gray-400 dark:text-white hover:text-lightBlue-600 dark:hover:text-pink-500",href:"https://www.linkedin.com/in/katherineoelsner/",target:"_blank",children:(0,a.jsx)(s.G,{className:"mr-6 text-2xl",icon:o.hwn})})]})]})]})}},3201:function(e,t,r){"use strict";r.r(t),r.d(t,{default:function(){return About}});var a=r(5893),i=r(8437),n=r(2023);function About(){return(0,a.jsx)(i.Z,{children:(0,a.jsxs)(n.E.div,{initial:{opacity:0},animate:{opacity:1},transition:{duration:.5,delay:.2},className:"px-4",children:[(0,a.jsx)("div",{className:"mb-6 text-center text-gray-800 dark:text-white",children:"Hi, I'm LimHai! I am a JUNIOR BACKEND DEVELOPERS at Developers Cambodia with a passion for developing web and mobile applications that make a positive impact on peoples lives."}),(0,a.jsx)("div",{className:"text-center text-gray-800 dark:text-white",children:"In addition to coding and learning new tech, I enjoy Football or Soccer, drinking coffee, playing guitar, reading, and hanging with my dog. If any of these things interest you too, I'd love to chat!"}),(0,a.jsx)("div",{className:"text-center text-gray-800 dark:text-white",children:"Can Ask Me ABout Spring Framework , Microservice And  Web Design..."})]},"about")})}}},function(e){e.O(0,[948,876,774,888,179],function(){return e(e.s=512)}),_N_E=e.O()}]);