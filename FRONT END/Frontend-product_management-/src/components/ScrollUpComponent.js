import React from 'react';

function ScrollUpComponent() {
    return (
        <>
            <a id="scrollUp" href="#top" className={"fixed z-50 block justify-center flex"}>
                <svg className="w-[37px] h-[37px] text-gray-800 dark:text-white" aria-hidden="true"
                     xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 8">
                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                          d="M13 7 7.674 1.3a.91.91 0 0 0-1.348 0L1 7"/>
                </svg>
            </a>
        </>
    );
}

export default ScrollUpComponent;