import React from "react";
import SliderIntroduct from "@/components/SliderIntroduct";
import Image from 'next/image'

export default function page() {
  return (
    <>
      
      <div className="container">
      <h1 className="text-center">hello everyone</h1>
      
       <div className="row justify-content-center m-28">
        <div className="col-8 col-lg-4 mx-auto pb-5 lg-pb-16 shadow-lg">
          <svg
            className="w-100"
            viewBox="0 0 499 665"
            xmlns="http://www.w3.org/2000/svg"
          >
            <g id="v93ceod__thumbnail" fill="#262626">
              <g id="v93ceod__left-man" transform="translate(128, 138)">
                <g id="v93ceod__body">
                  <rect
                    className="rounded-lg"
                    x="17"
                    y="232"
                    width="87"
                    height="157"
                    rx="43.5"
                  ></rect>
                  <path
                    d="M60,85 C93.137085,85 120,111.862915 120,145 L120,214.287291 C120,263.171206 84.6586957,304.890217 36.4398987,312.926684 L0,319 L0,319 L0,299 L0,145 C-4.05812251e-15,111.862915 26.862915,85 60,85 Z"
                    id="v93ceod__torso"
                    fill="#454545"
                  ></path>
                  <circle
                    id="v93ceod__head"
                    fill="#EEDCBA"
                    cx="114"
                    cy="60"
                    r="60"
                  ></circle>
                  <polyline
                    id="v93ceod__Path"
                    stroke="#98876F"
                    stroke-width="5"
                    points="145.193359 96.4101562 141.178674 89.671875 135.457031 89.671875 133.827042 85 126.905273 85.2568359"
                  ></polyline>
                </g>
                <g
                  id="v93ceod__eyes"
                  transform="translate(152.406114, 65.000000) rotate(15.000000) translate(-152.406114, -65.000000) translate(142.906114, 58.000000)"
                  stroke="#98876F"
                  stroke-linecap="round"
                  stroke-width="5"
                >
                  <line
                    x1="17.5938858"
                    y1="12.5"
                    x2="4.59388582"
                    y2="0.5"
                    id="v93ceod__Line"
                  ></line>
                  <line
                    x1="17.1877716"
                    y1="13.0964557"
                    x2="1.70530257e-13"
                    y2="8.90354429"
                    id="v93ceod__Line-Copy"
                  ></line>
                </g>
                <g
                  id="v93ceod__arm"
                  transform="translate(147.690288, 133.162696) scale(-1, 1) rotate(57.000000) translate(-147.690288, -133.162696) translate(71.190288, 70.162696)"
                >
                  <rect
                    fill="#EEDCBA"
                    transform="translate(56.977546, 73.246892) rotate(-58.000000) translate(-56.977546, -73.246892)"
                    x="32.9775459"
                    y="21.746892"
                    width="48"
                    height="103"
                    rx="24"
                  ></rect>
                  <rect
                    id="v93ceod__shoulder"
                    fill="#454545"
                    transform="translate(100.117930, 63.000000) rotate(30.000000) translate(-100.117930, -63.000000)"
                    x="71.1179296"
                    y="8"
                    width="58"
                    height="110"
                    rx="29"
                  ></rect>
                </g>
              </g>
            </g>
          </svg>
        </div>
      </div></div>
     
      <div className="container">
        <div className="row justify-content-center">
          <div className="col-lg-8">
            <div className="text-center text-xl">
              <div className="text-gray-500 mb-8 uppercase text-base font-medium tracking-widest font-mono">
                <a
                  href="/blog?category=culture"
                  className="text-black hover:underline hover:text-gray-600"
                >
                  Culture
                </a>
                <span className="mx-3 text-gray-300">—</span>
                <span>27 December 2018</span>
              </div>
              <h1 className="text-4xl lg:text-6xl font-extrabold">
                The Art of Code Review
              </h1>
            </div>
          </div>
        </div>
      </div>





      <main className="post-content max-w-3xl mx-auto">
        <h2>Introduction</h2>
        <p>
          Hi! My name is Limhai, and I am a backend who spent the last
          1 years developing a multi-country e-commerce solution with millions
          of euro of annual revenue. During that journey I had a chance to work
          with more than 15 front-end engineers of different seniority level,
          teaching them what I knew and learning from them what I didn’t. Today
          I would like to share my experience being a code reviewer, and give
          you some pieces of advice to become a good one.
        </p>
        <p>
          I have been known for my notorious code reviews within the team, which
          some people hated, and others hated even more. In the end, it’s a joy
          to see the people who despised my reviews coming back and thanking me
          for a great time we both spent improving. Undoubtedly, my reviewing
          skills have a long way to go, but the positive feedback I’ve received
          over time motivated me to write this article. I would like to explore
          what made people love and hate my reviews, and how you can learn from
          that to become a better reviewer in your team.
        </p>
        <hr />
        <h2>Code review is a part of development</h2>
        <p>
          I will start from assuring you that a code review by no means bears a
          lesser priority in your work than actual coding. I would argue that
          it’s even more important, since it’s one of the most useful feedback
          loops you can get for free. A flaw in the logic discovered at the
          review phase can save unnecessary stress for you and wasted money for
          your customer.
        </p>
        <p>
          <img
            alt="Image of a man behind computers"
            src="https://spring.io/img/og-spring.png"
          />
        </p>
        <p>
          Understanding the importance of code review as a part of your job is
          great, but make sure the other team members are on the same page with
          you. That doest concern developers only, but project managers, scrum
          masters, product owners, and, most importantly, clients.
        </p>
        <article className="blockquote">
          <p>
            Code review is not a voluntary activity, but a righteous duty that
            must be accounted, respected, and paid.
          </p>
        </article>
        <p>
          Don’t be afraid to dive deeper into the code you’re reviewing, open a
          source code and browse through the related files to understand the
          nature of the changes better. With more pull requests behind your
          back, you will be able to perform that much faster, thus, delivering a
          profound in-depth feature analysis. On the contrary, neglecting things
          in a review may backfire into much more work than it would’ve taken to
          get your head around the changes.
        </p>
        <p>
          Here are a few arguments I find useful when explaining how code review
          contributes to a product:
        </p>
        <ul>
          <li>It ensures quality of the code, thus, quality of a product;</li>
          <li>
            It reduces the amount of technical debt in the future, making the
            maintenance cost lower;
          </li>
          <li>
            It provides knowledge sharing between developers, resulting in more
            effective work and eliminating the bus factor.
          </li>
        </ul>
        <hr />
        <h2>Polite reviewer, sensible issuer</h2>
        <p>
          Be polite in your code reviews. We are all humans doing our job and we
          strive to do it the best we can. While this sounds obvious, you may
          find a lot about your colleague if you ask them for a code review at
          5PM on Friday before their long-awaited vacation.
        </p>
        <p>
          <img
            alt="Image of a woman and a man pair programming"
            src="https://redd.one/blog/the-art-of-code-review/typewriter-YWBAEYNN.svg"
          />
        </p>
        <p>
          One of the hardest parts of giving a code review is when your
          suggestions are taken as a personal offense. It’s understandable that
          nobody likes to spend a week on a feature and hear that they need to
          redo everything. That hurts for both the issuer and the reviewer.{" "}
          <strong>Let=s not do that</strong>.
        </p>
        <p>
          In my practice, such situations happen for two reasons, which m
          going to describe below.
        </p>
        <h3>Reason #1: Bad start</h3>
        <p>
          This often happens to people who rush into development without
          properly thinking the changes through. I am strongly convinced that a
          day of thinking saves a week of work.
        </p>
        <article className="blockquote">
          <p>
            Dont be afraid to ask and discuss! It either confirms your approach
            or saves a week of work in the wrong direction.
          </p>
        </article>
        <p>
          While this is feasible in a team, those who work alone may struggle to
          get their ideas evaluated. Bear in mind that there are plenty of
          people who can help you. You are not alone.
        </p>
        <p>
          <strong>
            Here are the links to some of my favorite engineering communities:
          </strong>
        </p>


        <h3>Reason #2: The way you say it</h3>
        <p>
          There is a fine line between its awful, redo  and a meaningful
          explanation of why there is a better way to do it. Remember that a
          reviewers role is to act as a fresh pair of eyes. Trying to
          understand the changes and showing compassion when something needs to
          be reworked are the keys to maintaining a healthy working relationship
          between the issuer and the reviewer.
        </p>
        <article className="blockquote">
          <p>Code review is a conversation, not a queue of commands.</p>
        </article>
        <p>
          Its a good gesture to include technical explanations and links to
          useful articles or resources whenever requesting a change. Because a
          change request shouldnt be taken as your sole desire but as a
          necessary measure that benefits everybody. If the time is critical,
          its useful to give your colleague a hand or, perhaps, pair program to
          achieve the common goal, which is quality code being merged. Turning
          an unpleasant fact of redoing your work into a supportive opportunity
          to learn is a great twist of events!
        </p>
        <hr />
        <h2>Review logic, not semicolons</h2>
        <p>
          There was a time I had been evaluating missing commas and semicolons
          during my reviews. What a shame. This is redundant and contributes to
          absolutely nothing, but it’s a good example of how technical debt is
          paid by wasting everybody’s time. We didn’t have any code
          auto-formatting, and people often ignored ESLint warnings in the
          console. Eh, those dark times.
        </p>
        <p>
          <img
            alt="Image of two women near a big typewriter"
            src="https://redd.one/blog/the-art-of-code-review/pair-programming-J32AE7GR.svg"
          />
        </p>
        <article className="blockquote">
          <p>
            
          </p>
        </article>
        <p>
          Using tools like{" "}
          <a href="https://prettier.io/" target="_blank" rel="noreferrer">
            Prettier
          </a>{" "}
         
        </p>
        <hr />
        <h2>Dealing with big changes</h2>
        <p>
          
        </p>
        <p>
          <img
            alt="Image of a man behind a computer and a Git commit tree"
            src="https://redd.one/blog/the-art-of-code-review/man-computer-TL4PR3KX.svg"
          />
        </p>
        <article className="blockquote">
          <p>
            
          </p>
        </article>
        <p>
          
        </p>
        <article className="blockquote">
          <p>
            
          </p>
        </article>
        <p>
          
        </p>
        <p>
          
        </p>
        <p>
          
        </p>
        <hr />
        <h2>Afterword</h2>
        <p>
          
        </p>
      </main>
      <SliderIntroduct/>
    </>
  );
}
