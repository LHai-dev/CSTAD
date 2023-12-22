"use client";
import React, { useEffect } from "react";
import { Carousel } from "flowbite-react";
import AOS from "aos";
import "aos/dist/aos.css"; // You can also use <link> for styles
// ..
import ControlledComponet from "@/components/ControlledComponet";
export default function Page() {
  useEffect(() => {
    AOS.init();
  }, []);
  return (
    <div>
      <div className="container">
        {/* <!-- Carousel wrapper --> */}
        <div>
          <ControlledComponet />
        </div>
        {/* <!-- Carousel wrapper --> */}

        {/* <!-- Carousel wrapper --> */}

        {/* <!-- Carousel wrapper --> */}
      </div>

      <section className="bg-white dark:bg-gray-900">
        <div className="gap-16 items-center py-8 px-4 mx-auto max-w-screen-xl lg:grid lg:grid-cols-2 lg:py-16 lg:px-6">
          <div className="font-light text-gray-500 sm:text-lg dark:text-gray-400">
            <h2 className="mb-4 text-4xl tracking-tight font-extrabold text-gray-900 dark:text-black">
              ដំណើរកំសាន្តទៅខេត្តកំពតឆ្នាំ 12/2022
            </h2>
            <p className="mb-4 limhai">
              នេះគឺជារូបភាពនិងវីដេអូដែលយើងមានដំណើរកម្សាន្តជាមួយគ្នានៅខេត្តកំពតនៅឆ្នាំ
              2022
              ហើយដំណើរកម្សាន្តនេះនិងចងចាំក្នុងជីវិតយើងអស់មួយជីវិតនិងនៅមានដំណើរកម្សាន្តបន្តទៀតដែលយើងមានគម្រោងនៅឆ្នាំខាងមុខ
            </p>
            <p>
              ជីវិតរបស់យើងដូចផ្ទៃមេឃ មិនមានថ្ងៃណាដែលដូចគ្នាសោះឡើយ ថ្ងៃខ្លះក៏ងងឹត
              ថ្ងៃខ្លះក៏ស្រស់់ស្រាយ
            </p>
          </div>
          <div data-aos="fade-up">
            {" "}
            <div className="grid grid-cols-2 gap-4 mt-8">
              <img
                className="w-full rounded-lg"
                src="https://scontent.fpnh11-1.fna.fbcdn.net/v/t39.30808-6/350112670_263044512955238_185945768444802626_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=730e14&_nc_ohc=8-Nch6fYEN0AX8m-XLF&_nc_oc=AQkrCiwOyT9tfWDxfmeh29lLFjMNaWAEDbV-GGeUEixgEHLtYQI-Gmhnyxm4W9WrqHk&_nc_ht=scontent.fpnh11-1.fna&oh=00_AfDc1jBJmNcwjTKj0DNUiZt-7t5Jp3nSVpKVobcq53sdOg&oe=6475548C"
                alt="office content 1"
              />
              <img
                className="mt-4 w-full lg:mt-10 rounded-lg"
                src="https://scontent.fpnh11-1.fna.fbcdn.net/v/t39.30808-6/349722924_807738970963149_504462724289943675_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=730e14&_nc_ohc=q8n_W74YVSQAX9QTreH&_nc_ht=scontent.fpnh11-1.fna&oh=00_AfByujai43xeZXwwMpFy5t_e0s_OCPURMQNWEhM3gijgBw&oe=64756081"
                alt="office content 2"
              />
            </div>
          </div>
        </div>
      </section>

      <section className="bg-white dark:bg-gray-900">
        <div className="gap-16 items-center py-8 px-4 mx-auto max-w-screen-xl lg:grid lg:grid-cols-2 lg:py-16 lg:px-6">
          <div data-aos="zoom-in-left">
            <div className="grid grid-cols-2 gap-4 mt-8">
              <img
                className="w-full rounded-lg"
                src="https://scontent.fpnh11-1.fna.fbcdn.net/v/t39.30808-6/349076999_1413947379396116_3496885198303277926_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=730e14&_nc_ohc=Q2-jfd0Zke0AX_PU5IM&_nc_ht=scontent.fpnh11-1.fna&oh=00_AfDIANGHBmnsOqLtFQBrxGJE2FT-ayhu8-M34TIGrzLT3A&oe=64768C0D"
                alt="office content 1"
              />
              <img
                className="mt-4 w-full lg:mt-10 rounded-lg"
                src="https://scontent.fpnh11-2.fna.fbcdn.net/v/t39.30808-6/349159533_218809297611245_6060132819677055691_n.jpg?_nc_cat=104&ccb=1-7&_nc_sid=730e14&_nc_ohc=ztdcZh0I4SUAX--0-Nm&_nc_oc=AQm95MMsUhRk8He0BcGdf_DY0M-JSnNWHbiDvr-9-5XqgKInacsm8ay2Rs-LZ15POmo&_nc_ht=scontent.fpnh11-2.fna&oh=00_AfC5YppPymRfJIVULqgXZXBnBWknvt_m1DEgh6lfzjmlzQ&oe=64756D26"
                alt="office content 2"
              />
            </div>
          </div>

          <div data-aos="flip-right">
            {" "}
            <div className="grid grid-cols-2 gap-4 mt-8">
              <img
                className="w-full rounded-lg"
                src="https://scontent.fpnh11-2.fna.fbcdn.net/v/t39.30808-6/349158354_780614160204202_7791221216904392025_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=730e14&_nc_ohc=NJQpCBhujmEAX-pLh_c&_nc_ht=scontent.fpnh11-2.fna&oh=00_AfBwhmuGWQMa35-s6POUXic6P3XrcltX1TJu-CS0w_eFmQ&oe=6475A008"
                alt="office content 1"
              />
              <img
                className="mt-4 w-full lg:mt-10 rounded-lg"
                src="https://scontent.fpnh11-1.fna.fbcdn.net/v/t39.30808-6/349157671_1598997167262294_5997527091999834483_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=730e14&_nc_ohc=2BwulaiAZj4AX8dWivZ&_nc_ht=scontent.fpnh11-1.fna&oh=00_AfDXryynF2yczIuYp2mxWH1NgISI_rKqmsiKaJmiBn-CVA&oe=6475A601"
                alt="office content 2"
              />
            </div>
          </div>
        </div>
      </section>

      <div>
        <section class="">
          {/* <!-- Section: Images --> */}
          <div className="mb-20">
            <section class="">
              <div class="row">
                <div class="col-lg-4 col-md-12 mb-4 mb-lg-0">
                  <div data-aos="fade-up" data-aos-duration="3000">
                    <div
                      class="bg-image hover-overlay ripple shadow-1-strong rounded"
                      data-ripple-color="light"
                    >
                      <img
                        src="https://scontent.fpnh11-2.fna.fbcdn.net/v/t39.30808-6/349590083_937184400886625_4662913972309836401_n.jpg?_nc_cat=104&ccb=1-7&_nc_sid=730e14&_nc_ohc=QMf2sdCajK0AX-6TFOi&_nc_ht=scontent.fpnh11-2.fna&oh=00_AfCzExgIqI829RbodCvRaPd5nmaYxhYVG-waRE_26EiFiQ&oe=6475A993"
                        class="w-100"
                      />
                      <a
                        href="#!"
                        data-mdb-toggle="modal"
                        data-mdb-target="#exampleModal1"
                      >
                        <div class="mask"></div>
                      </a>
                    </div>
                  </div>
                </div>

                <div class="col-lg-4 mb-4 mb-lg-0">
                  <div data-aos="zoom-out-left">
                    {" "}
                    <div
                      class="bg-image hover-overlay ripple shadow-1-strong rounded"
                      data-ripple-color="light"
                    >
                      <img
                        src="https://scontent.fpnh11-2.fna.fbcdn.net/v/t39.30808-6/349753996_5602971103137161_7960287881984471088_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=730e14&_nc_ohc=2S-pE9xQvFMAX-V_oYl&_nc_ht=scontent.fpnh11-2.fna&oh=00_AfAyShziLRBfffZ6vRXf4sm4szcOp-hZhO_vCsPA-D_7cQ&oe=6474F72B"
                        class="w-100"
                      />
                      <a
                        href="#!"
                        data-mdb-toggle="modal"
                        data-mdb-target="#exampleModal2"
                      >
                        <div class="mask"></div>
                      </a>
                    </div>
                  </div>
                </div>

                <div class="col-lg-4 mb-4 mb-lg-0">
                  <div data-aos="zoom-out">
                    {" "}
                    <div
                      class="bg-image hover-overlay ripple shadow-1-strong rounded"
                      data-ripple-color="light"
                    >
                      <img
                        src="https://scontent.fpnh11-2.fna.fbcdn.net/v/t39.30808-6/349160930_1395792064573543_7927738461503754672_n.jpg?_nc_cat=104&ccb=1-7&_nc_sid=730e14&_nc_ohc=ac-fDvxR7B8AX_DB3aA&_nc_ht=scontent.fpnh11-2.fna&oh=00_AfCGGLwAkjCEuyGXglounmkGEXD49Gig7SndEPv4IFCGBg&oe=64769211"
                        class="w-100"
                      />
                      <a
                        href="#!"
                        data-mdb-toggle="modal"
                        data-mdb-target="#exampleModal3"
                      >
                        <div class="mask"></div>
                      </a>
                    </div>
                  </div>
                </div>
              </div>
            </section>
          </div>

          {/* <!-- Section: Images --> */}

          {/* <!-- Section: Modals --> */}
          <section class="">
            {/* <!-- Modal 1 --> */}
            <div
              class="modal fade"
              id="exampleModal1"
              tabindex="-1"
              aria-labelledby="exampleModal1Label"
              aria-hidden="true"
            >
              <div class="modal-dialog modal-lg">
                <div class="modal-content">
                  <div class="ratio ratio-16x9">
                    <iframe
                      src="https://www.youtube.com/embed/A3PDXmYoF5U"
                      title="YouTube video"
                      allowfullscreen
                    ></iframe>
                  </div>

                  <div class="text-center py-3">
                    <button
                      type="button"
                      class="btn btn-secondary"
                      data-mdb-dismiss="modal"
                    >
                      Close
                    </button>
                  </div>
                </div>
              </div>
            </div>
            {/* <!-- Modal 2 --> */}
            <div
              class="modal fade"
              id="exampleModal2"
              tabindex="-1"
              aria-labelledby="exampleModal2Label"
              aria-hidden="true"
            >
              <div class="modal-dialog modal-lg">
                <div class="modal-content">
                  <div class="ratio ratio-16x9">
                    <iframe
                      src="https://www.youtube.com/embed/wTcNtgA6gHs"
                      title="YouTube video"
                      allowfullscreen
                    ></iframe>
                  </div>

                  <div class="text-center py-3">
                    <button
                      type="button"
                      class="btn btn-secondary"
                      data-mdb-dismiss="modal"
                    >
                      Close
                    </button>
                  </div>
                </div>
              </div>
            </div>
            {/* <!-- Modal 3 --> */}
            <div
              class="modal fade"
              id="exampleModal3"
              tabindex="-1"
              aria-labelledby="exampleModal3Label"
              aria-hidden="true"
            >
              <div class="modal-dialog modal-lg">
                <div class="modal-content">
                  <div class="ratio ratio-16x9">
                    <iframe
                      src="https://www.youtube.com/embed/vlDzYIIOYmM"
                      title="YouTube video"
                      allowfullscreen
                    ></iframe>
                  </div>

                  <div class="text-center py-3">
                    <button
                      type="button"
                      class="btn btn-secondary"
                      data-mdb-dismiss="modal"
                    >
                      Close
                    </button>
                  </div>
                </div>
              </div>
            </div>
          </section>
          {/* <!-- Section: Modals --> */}
        </section>
        {/* <!-- Modal gallery --> */}
      </div>

      {/* image */}
      {/* <!-- Gallery --> */}
      <div>
        <div>
          <div className="row">
            <div className="col-lg-4 col-md-12 mb-4 mb-lg-0">
            <div data-aos="zoom-out"> <img
                src="https://scontent.fpnh11-2.fna.fbcdn.net/v/t39.30808-6/349152787_569787741892316_89611971407503401_n.jpg?_nc_cat=104&ccb=1-7&_nc_sid=730e14&_nc_ohc=XC8dt3Ph3JAAX8r3vQM&_nc_ht=scontent.fpnh11-2.fna&oh=00_AfAbxBS9ZmvhecYmSJtLtBE2Us7LdrM9zejFILq0pRO7FQ&oe=647626E8"
                className="w-100 shadow-1-strong rounded mb-4"
                alt="Boat on Calm Water"
              /></div>

             
<div data-aos="zoom-out-left">           <img
                src="https://scontent.fpnh11-1.fna.fbcdn.net/v/t39.30808-6/349151876_157122683852438_5118147254135762874_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=730e14&_nc_ohc=DDIwuXfOThwAX8ZU3wA&_nc_ht=scontent.fpnh11-1.fna&oh=00_AfCIs4HPp50aAf9NRmJz_PSzo7OwVXBU6FvYFtjBvk6cUQ&oe=6474C3B2"
                className="w-100 shadow-1-strong rounded mb-4"
                alt="Wintry Mountain Landscape"
              /></div>

   
            </div>

            <div className="col-lg-4 mb-4 mb-lg-0">
            <div data-aos="flip-left"
     data-aos-easing="ease-out-cubic"
     data-aos-duration="2000">
          <img
                src="https://scontent.fpnh11-2.fna.fbcdn.net/v/t39.30808-6/350121491_132203956495457_3005723061639593056_n.jpg?_nc_cat=111&ccb=1-7&_nc_sid=730e14&_nc_ohc=cdA0VSt_yiYAX8Gexok&_nc_ht=scontent.fpnh11-2.fna&oh=00_AfAvuPt4wpMFEJpETpdCK3SnMXv9ryUaZP5xSV_JFor7Uw&oe=64764727"
                className="w-100 shadow-1-strong rounded mb-4"
                alt="Mountains in the Clouds"
              />
</div>
         
         <div data-aos="fade-left"
     data-aos-anchor="#example-anchor"
     data-aos-offset="500"
     data-aos-duration="500">
                  <img
                src="https://scontent.fpnh11-1.fna.fbcdn.net/v/t39.30808-6/348913549_1023363265493477_4961667544978886248_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=730e14&_nc_ohc=EiARTwrmw9UAX-a7ZtQ&_nc_ht=scontent.fpnh11-1.fna&oh=00_AfBAW99dWfo6fgHcqwH149yGhI9P4u7_Zkh08HL07mxPSQ&oe=64769C6A"
                className="w-100 shadow-1-strong rounded mb-4"
                alt="Boat on Calm Water"
              />
            </div>
</div>
 

            <div className="col-lg-4 mb-4 mb-lg-0">
            <div data-aos="fade-down"
     data-aos-easing="linear"
     data-aos-duration="1500">
                <img
                src="https://scontent.fpnh11-1.fna.fbcdn.net/v/t39.30808-6/349948544_1235093013876679_1393895489140581857_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=730e14&_nc_ohc=p7WogAhAbk0AX8ChqRc&_nc_ht=scontent.fpnh11-1.fna&oh=00_AfBYmSt_x8w4LShpa3vrfmY6SU-WEPJ2_OdkbD0wFP0g4Q&oe=64768B72"
                className="w-100 shadow-1-strong rounded mb-4"
                alt="Waves at Sea"
              />

</div>
   <div data-aos="fade-right"
     data-aos-offset="300"
     data-aos-easing="ease-in-sine">
                 <img
                src="https://scontent.fpnh11-1.fna.fbcdn.net/v/t39.30808-6/349599479_754749233060664_520499901280503308_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=730e14&_nc_ohc=B3pzWnpiBKIAX-Sgu7d&_nc_ht=scontent.fpnh11-1.fna&oh=00_AfDBS2n3vOvZ1iU4Dfnvsbnaj4Xn1y0Rac4Kd__7SRgmHA&oe=6475DF73"
                className="w-100 shadow-1-strong rounded mb-4"
                alt="Yosemite National Park"
              />
</div>
  
            </div>
          </div>
        </div>
        <div>
          <div className="row">
            <div className="col-lg-4 col-md-12 mb-4 mb-lg-0">
              <img
                src="https://scontent.fpnh11-2.fna.fbcdn.net/v/t39.30808-6/350129004_787854986680823_4148535295718360827_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=730e14&_nc_ohc=fJO1uwX1m8kAX9Y5GEn&_nc_ht=scontent.fpnh11-2.fna&oh=00_AfBu8-hmuzBeJoNyoW7POejsWI4BiJjzxsJ1wsy5wHFqmw&oe=647554AE"
                className="w-100 shadow-1-strong rounded mb-4"
                alt="Boat on Calm Water"
              />

              <img
                src="https://scontent.fpnh11-1.fna.fbcdn.net/v/t39.30808-6/349644234_984111952602982_1765822609599588363_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=730e14&_nc_ohc=QZg9tdQX5QwAX9VvfG9&_nc_ht=scontent.fpnh11-1.fna&oh=00_AfBjEYqqFAeFrIeklhJ8CT-cH7fcvJjEFMkbXl2F578SWQ&oe=6474EBE4"
                className="w-100 shadow-1-strong rounded mb-4"
                alt="Wintry Mountain Landscape"
              />
            </div>

            <div className="col-lg-4 mb-4 mb-lg-0">
              <img
                src="https://scontent.fpnh11-2.fna.fbcdn.net/v/t39.30808-6/349179084_1582699255589460_6556144538841844447_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=730e14&_nc_ohc=OV3LIJ5NYZ0AX8rD-Mq&_nc_ht=scontent.fpnh11-2.fna&oh=00_AfClHurB1Rv78yi6bCL8Ida6D7POPd4JIUTfP_BDAj3EEQ&oe=6474BD7B"
                className="w-100 shadow-1-strong rounded mb-4"
                alt="Mountains in the Clouds"
              />

              <img
                src="https://scontent.fpnh11-2.fna.fbcdn.net/v/t39.30808-6/319817320_905221297522116_8902514005761045198_n.jpg?stp=dst-jpg_s1080x2048&_nc_cat=101&ccb=1-7&_nc_sid=5b7eaf&_nc_ohc=PlOdwvZIpj4AX-uWFjp&_nc_ht=scontent.fpnh11-2.fna&oh=00_AfCLhJMb2MDM1I_4b7HKD_rbdk8SaJ1MhHmoJZEN4Dkv7A&oe=6474EE3A"
                className="w-100 shadow-1-strong rounded mb-4"
                alt="Boat on Calm Water"
              />
            </div>

            <div className="col-lg-4 mb-4 mb-lg-0">
              <img
                src="https://scontent.fpnh11-2.fna.fbcdn.net/v/t39.30808-6/349159164_195585630099384_288428394717001688_n.jpg?_nc_cat=104&ccb=1-7&_nc_sid=730e14&_nc_ohc=RBXaX0s5GbYAX9wit_k&_nc_ht=scontent.fpnh11-2.fna&oh=00_AfCLYnPRnqRsEAYAj70321ic0g5aB6KTOOOELqsWALV-rw&oe=64769A1B"
                className="w-100 shadow-1-strong rounded mb-4"
                alt="Waves at Sea"
              />

              <img
                src="https://scontent.fpnh11-1.fna.fbcdn.net/v/t39.30808-6/349788293_1698973447217467_2462051068949537915_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=730e14&_nc_ohc=8XPMfufY-aoAX_wv4xu&_nc_ht=scontent.fpnh11-1.fna&oh=00_AfBk2SafOV5kwblCf7uDB107AEekzVN8Ch95bPWr1rjk7Q&oe=6476083B"
                className="w-100 shadow-1-strong rounded mb-4"
                alt="Yosemite National Park"
              />
            </div>
          </div>
        </div>
        {/* <!-- Gallery --> */}

        {/* Advanced multi-item carousel */}
        <div>
          {/* <!-- Modal gallery --> */}
          <section className="">
            {/* <!-- Section: Images --> */}
            <section className="">
              <div className="row">
                <div className="col-lg-4 col-md-12 mb-4 mb-lg-0">
                  <div
                    className="bg-image hover-overlay ripple shadow-1-strong rounded"
                    data-ripple-color="light"
                  >
                    <img
                      src="https://scontent.fpnh11-1.fna.fbcdn.net/v/t39.30808-6/349157671_1598997167262294_5997527091999834483_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=730e14&_nc_ohc=2BwulaiAZj4AX8dWivZ&_nc_ht=scontent.fpnh11-1.fna&oh=00_AfDXryynF2yczIuYp2mxWH1NgISI_rKqmsiKaJmiBn-CVA&oe=6475A601"
                      className="w-100"
                    />
                    <a
                      href="#!"
                      data-mdb-toggle="modal"
                      data-mdb-target="#exampleModal1"
                    >
                      <div className="mask"></div>
                    </a>
                  </div>
                </div>

                <div className="col-lg-4 mb-4 mb-lg-0">
                  <div
                    className="bg-image hover-overlay ripple shadow-1-strong rounded"
                    data-ripple-color="light"
                  >
                    <img
                      src="https://scontent.fpnh11-1.fna.fbcdn.net/v/t39.30808-6/349076999_1413947379396116_3496885198303277926_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=730e14&_nc_ohc=Q2-jfd0Zke0AX_PU5IM&_nc_ht=scontent.fpnh11-1.fna&oh=00_AfDIANGHBmnsOqLtFQBrxGJE2FT-ayhu8-M34TIGrzLT3A&oe=64768C0D"
                      className="w-100"
                    />
                    <a
                      href="#!"
                      data-mdb-toggle="modal"
                      data-mdb-target="#exampleModal2"
                    >
                      <div className="mask"></div>
                    </a>
                  </div>
                </div>

                <div className="col-lg-4 mb-4 mb-lg-0">
                  <div
                    className="bg-image hover-overlay ripple shadow-1-strong rounded"
                    data-ripple-color="light"
                  >
                    <img
                      src="https://scontent.fpnh11-2.fna.fbcdn.net/v/t39.30808-6/349158354_780614160204202_7791221216904392025_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=730e14&_nc_ohc=NJQpCBhujmEAX-pLh_c&_nc_ht=scontent.fpnh11-2.fna&oh=00_AfBwhmuGWQMa35-s6POUXic6P3XrcltX1TJu-CS0w_eFmQ&oe=6475A008"
                      className="w-100"
                    />
                    <a
                      href="#!"
                      data-mdb-toggle="modal"
                      data-mdb-target="#exampleModal3"
                    >
                      <div className="mask"></div>
                    </a>
                  </div>
                </div>
              </div>
            </section>
            {/* <!-- Section: Images --> */}

            {/* <!-- Section: Modals --> */}

            {/* <!-- Section: Modals --> */}
          </section>
          {/* <!-- Modal gallery --> */}
        </div>
      </div>
      <div className="row">
        <div className="col-lg-4 col-md-12 mb-4 mb-lg-0">
          <div data-aos="flip-left">
            <img
              src="https://scontent.fpnh11-1.fna.fbcdn.net/v/t39.30808-6/349165068_175666185459610_2576897138291736158_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=730e14&_nc_ohc=2kX7cFTfOqgAX8dZSNW&_nc_ht=scontent.fpnh11-1.fna&oh=00_AfCN1Wrw0FyAsWLsXbO2dHaVdRy7RTvVnOpwIPJ4Pxg2FA&oe=64763DF6"
              className="w-100 shadow-1-strong rounded mb-4"
              alt="Boat on Calm Water"
            />
          </div>
          <div data-aos="fade-down-left">
            <img
              src="https://scontent.fpnh11-2.fna.fbcdn.net/v/t39.30808-6/350129643_930824328286247_6244146269104610573_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=730e14&_nc_ohc=bR-bVshMPScAX9x9ut7&_nc_ht=scontent.fpnh11-2.fna&oh=00_AfB848KVT5Ps7i80nJ8RVANvajat8SHYL4L7Jar0RlrPWw&oe=6474D675"
              className="w-100 shadow-1-strong rounded mb-4"
              alt="Wintry Mountain Landscape"
            />
          </div>

          <div data-aos="flip-left">
            {" "}
            <img
              src="https://scontent.fpnh11-1.fna.fbcdn.net/v/t39.30808-6/349165068_175666185459610_2576897138291736158_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=730e14&_nc_ohc=2kX7cFTfOqgAX8dZSNW&_nc_ht=scontent.fpnh11-1.fna&oh=00_AfCN1Wrw0FyAsWLsXbO2dHaVdRy7RTvVnOpwIPJ4Pxg2FA&oe=64763DF6"
              className="w-100 shadow-1-strong rounded mb-4"
              alt="Boat on Calm Water"
            />
          </div>

          <div data-aos="flip-right">
            <img
              src="https://scontent.fpnh11-2.fna.fbcdn.net/v/t39.30808-6/350129643_930824328286247_6244146269104610573_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=730e14&_nc_ohc=bR-bVshMPScAX9x9ut7&_nc_ht=scontent.fpnh11-2.fna&oh=00_AfB848KVT5Ps7i80nJ8RVANvajat8SHYL4L7Jar0RlrPWw&oe=6474D675"
              className="w-100 shadow-1-strong rounded mb-4"
              alt="Wintry Mountain Landscape"
            />
          </div>
        </div>

        <div className="col-lg-4 mb-4 mb-lg-0">
          <div data-aos="flip-up">
            {" "}
            <img
              src="https://scontent.fpnh11-2.fna.fbcdn.net/v/t39.30808-6/349158354_780614160204202_7791221216904392025_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=730e14&_nc_ohc=NJQpCBhujmEAX-pLh_c&_nc_ht=scontent.fpnh11-2.fna&oh=00_AfBwhmuGWQMa35-s6POUXic6P3XrcltX1TJu-CS0w_eFmQ&oe=6475A008"
              className="w-100 shadow-1-strong rounded mb-4"
              alt="Mountains in the Clouds"
            />
          </div>

          <div data-aos="flip-down">
            {" "}
            <img
              src="https://scontent.fpnh11-2.fna.fbcdn.net/v/t39.30808-6/349547094_655878549711539_2760747375850878451_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=730e14&_nc_ohc=-IP-nMEKKPoAX-92qXq&_nc_ht=scontent.fpnh11-2.fna&oh=00_AfDNstCVskE48FdlwLVc76jO9p7H-fHsCsOHevmlTAu98A&oe=6475C449"
              className="w-100 shadow-1-strong rounded mb-4"
              alt="Boat on Calm Water"
            />
          </div>
        </div>

        <div className="col-lg-4 mb-4 mb-lg-0">
          <div data-aos="zoom-in">
            {" "}
            <img
              src="https://scontent.fpnh11-1.fna.fbcdn.net/v/t39.30808-6/349146131_1073427940296896_8677186287874556697_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=730e14&_nc_ohc=kL-3C0pSi-IAX8KvTVF&_nc_ht=scontent.fpnh11-1.fna&oh=00_AfAH0Q8nz0quEEWGkvij57vpxfYy7yMP9cWvOiLinFNutA&oe=64753210"
              className="w-100 shadow-1-strong rounded mb-4"
              alt="Waves at Sea"
            />
          </div>
          <div data-aos="zoom-in-up">
            {" "}
            <img
              src="https://scontent.fpnh11-1.fna.fbcdn.net/v/t39.30808-6/349146131_1073427940296896_8677186287874556697_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=730e14&_nc_ohc=kL-3C0pSi-IAX8KvTVF&_nc_ht=scontent.fpnh11-1.fna&oh=00_AfAH0Q8nz0quEEWGkvij57vpxfYy7yMP9cWvOiLinFNutA&oe=64753210"
              className="w-100 shadow-1-strong rounded mb-4"
              alt="Waves at Sea"
            />
          </div>
          

          <div data-aos="zoom-in-down">
            <img
              src="https://scontent.fpnh11-1.fna.fbcdn.net/v/t39.30808-6/349603742_2262908520763468_4365864602069086341_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=730e14&_nc_ohc=6F1VQA141SgAX-HsQBz&_nc_ht=scontent.fpnh11-1.fna&oh=00_AfCSLapHQn9VXwBsAQbW7xeVeRz0T9wgA1hXa9TDf13yLQ&oe=6475C72C"
              className="w-100 shadow-1-strong rounded mb-4"
              alt="Yosemite National Park"
            />
          </div>
        </div>
      </div>
      <div
        data-aos="fade-right"
        data-aos-offset="300"
        data-aos-easing="ease-in-sine"
      >
        <div className="ratio ratio-16x9">
          <iframe
            width="560"
            height="315"
            src="https://www.youtube.com/embed/kLry7SJWri0"
            title="YouTube video player"
            frameborder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
            allowfullscreen
          ></iframe>
        </div>
      </div>
    </div>
  );
}
