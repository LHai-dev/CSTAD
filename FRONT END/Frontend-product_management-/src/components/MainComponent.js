"use strict";

// meanmenu
meanMenuInit();

// One Page Nav
var top_offset = document.querySelector('.header-area').offsetHeight - 10;
onePageNavInit(top_offset);

window.addEventListener('scroll', function () {
    var scroll = window.pageYOffset || document.documentElement.scrollTop;
    if (scroll < 245) {
        removeClass(document.querySelector(".header-sticky"), "sticky");
        document.querySelector('header.header .widget-search').style.display = 'block';
        removeClass(document.querySelector('.hidden-scroll'), 'd-none-important');
        document.querySelector('.mt-scroll-0').style.marginTop = '30px';
    } else {
        addClass(document.querySelector(".header-sticky"), "sticky");
        document.querySelector('header.header').style.paddingTop = '30px';
        document.querySelector('header.header').style.paddingBottom = '15px';
        document.querySelector('.sticky').style.top = '0';
        document.querySelector('header.header .widget-search').style.display = 'none';
        addClass(document.querySelector('.hidden-scroll'), 'd-none-important');
        document.querySelector('.mt-scroll-0').style.marginTop = '0';
    }
});

window.addEventListener('load', function () {
    document.querySelector('#loader-wrapper').style.display = 'none';
});

// top left search focus
var searchInput = document.querySelector('.top-left-search-form form input');
var productShowBox = document.querySelector('.product-show-box');

searchInput.addEventListener('focusin', function () {
    productShowBox.style.display = 'block';
});

searchInput.addEventListener('focusout', function () {
    productShowBox.style.display = 'none';
});

// data background
var dataBackgrounds = document.querySelectorAll("[data-background]");
dataBackgrounds.forEach(function (element) {
    element.style.backgroundImage = "url(" + element.getAttribute("data-background") + ")";
});

// data bg color
var dataBgColors = document.querySelectorAll("[data-bg-color]");
dataBgColors.forEach(function (element) {
    element.style.background = element.getAttribute("data-bg-color");
});

// mainSlider
mainSlider();

// owlCarousel
owlCarouselInit('.new-arrival-carousel', {
    loop: true,
    margin: 0,
    items: 1,
    navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>'],
    nav: true,
    dots: false,
    responsive: {
        0: {
            items: 1
        },
        500: {
            items: 2
        },
        992: {
            items: 3
        },
        1200: {
            items: 4
        }
    }
});

owlCarouselInit('.blog-carousel', {
    loop: true,
    margin: 0,
    items: 1,
    navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>'],
    nav: true,
    dots: false,
    responsive: {
        0: {
            items: 1
        },
        500: {
            items: 1
        },
        700: {
            items: 2
        },
        1200: {
            items: 3
        }
    }
});

owlCarouselInit('.product-3-carousel', {
    loop: true,
    margin: 30,
    items: 1,
    navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>'],
    nav: true,
    dots: false,
    responsive: {
        0: {
            items: 1
        },
        500: {
            items: 1
        },
        700: {
            items: 2
        },
        1200: {
            items: 3
        }
    }
});

owlCarouselInit('.testimonial-carousel', {
    loop: true,
    smartSpeed: 1000,
    margin: 30,
    items: 1,
    navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>'],
    nav: false,
    dots: true,
});

owlCarouselInit('.main-product-carousel', {
    loop: true,
    margin: 0,
    items: 1,
    navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>'],
    nav: true,
    dots: false,
    responsive: {
        0: {
            items: 1
        },
        500: {
            items: 2
        },
        767: {
            items: 3
        },
        992: {
            items: 4
        },
        1200: {
            items: 5
        }
    }
});

owlCarouselInit('.small-img-carousel', {
    loop: true,
    margin: 20,
    items: 1,
    navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>'],
    nav: true,
    dots: false,
    responsive: {
        0: {
            items: 2
        },
        500: {
            items: 4
        },
        767: {
            items: 4
        },
        992: {
            items: 4
        },
        1200: {
            items: 5
        }
    }
});

owlCarouselInit('.main-product-carousel-4', {
    loop: true,
    margin: 0,
    items: 1,
    navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>'],
    nav: true,
    dots: false,
    responsive: {
        0: {
            items: 1
        },
        500: {
            items: 2
        },
        767: {
            items: 3
        },
        992: {
            items: 3
        },
        1200: {
            items: 4
        }
    }
});

// magnificPopup img view
magnificPopupInit('.popup-image', {
    type: 'image',
    gallery: {
        enabled: true
    }
});

// magnificPopup video view
magnificPopupInit('.video-popup', {
    type: 'iframe',
    iframe: {
        markup: '<div class="mfp-iframe-scaler">' +
            '<div class="mfp-close"></div>' +
            '<iframe class="mfp-iframe" frameborder="0" allowfullscreen></iframe>' +
            '</div>', // HTML markup of popup, `mfp-close` will be replaced by the close button

        patterns: {
            youtube: {
                index: 'youtube.com/',
                id: 'v=',

                src: 'https://www.youtube.com/embed/e2FKXPzsT7E'
            },

        },

        srcAction: 'iframe_src',
    }
});

// isotop
imagesLoadedInit('.grid', function () {
    var grid = document.querySelector('.grid');
    var iso = new Isotope(grid, {
        itemSelector: '.grid-item',
        percentPosition: true,
        masonry: {
            columnWidth: '.grid-item',
        }
    });

    // filter items on button click
    var filterButtons = document.querySelectorAll('.portfolio-menu button');
    filterButtons.forEach(function (button) {
        button.addEventListener('click', function () {
            var filterValue = button.getAttribute('data-filter');
            iso.arrange({
                filter: filterValue
            });
        });
    });

    // for menu active class
    filterButtons.forEach(function (button) {
        button.addEventListener('click', function (event) {
            var activeButton = document.querySelector('.portfolio-menu button.active');
            removeClass(activeButton, 'active');
            addClass(button, 'active');
            event.preventDefault();
        });
    });
});

// scrollToTop
$.scrollUp({
    scrollName: 'scrollUp', // Element ID
    topDistance: '300', // Distance from top before showing element (px)
    topSpeed: 300, // Speed back to top (ms)
    animation: 'fade', // Fade, slide, none
    animationInSpeed: 200, // Animation in speed (ms)
    animationOutSpeed: 200, // Animation out speed (ms)
    scrollText: "<i class='fal fa-angle-double-up'></i>", // Text for element
    activeOverlay: false, // Set CSS color to display scrollUp active point, e.g '#00FFFF'
});

// WOW active
new WOW().init();

// bootstrap tooltip
var tooltips = document.querySelectorAll('[data-toggle="tooltip"]');
tooltips.forEach(function (tooltip) {
    new bootstrap.Tooltip(tooltip);
});

// header search popup
var headerSearchIcon = document.querySelector('header.header i.fa-search');
var searchPopup = document.querySelector('#search-popup');
var closeSearchPopup = document.querySelector('.close-search-popup');

headerSearchIcon.addEventListener('click', function () {
    searchPopup.style.opacity = '1';
    searchPopup.style.visibility = 'visible';
});

closeSearchPopup.addEventListener('click', function () {
    searchPopup.style.opacity = '0';
    searchPopup.style.visibility = 'hidden';
});

// slick slider text content
document.getElementById('slick-slide-control00').innerHTML = 'Lookbook';
document.getElementById('slick-slide-control01').innerHTML = 'Over.S18';
document.getElementById('slick-slide-control02').innerHTML = 'Style.S16';

// slick slider number content
document.querySelector('.number-dots #slick-slide-control00').innerHTML = '01';
document.querySelector('.number-dots #slick-slide-control01').innerHTML = '02';
document.querySelector('.number-dots #slick-slide-control02').innerHTML = '03';

// Price filter active
var sliderRange = document.querySelector("#slider-range");
if (sliderRange) {
    var sliderValues = [75, 300];
    noUiSlider.create(sliderRange, {
        start: sliderValues,
        connect: true,
        range: {
            'min': 0,
            'max': 500
        }
    });
    var amount = document.getElementById('amount');
    sliderRange.noUiSlider.on('update', function (values) {
        amount.value = "$" + values[0] + " - $" + values[1];
    });

    var filterBtn = document.getElementById('filter-btn');
    if (filterBtn) {
        filterBtn.addEventListener('click', function () {
            var filterWidget = document.querySelector('.filter-widget');
            toggleSlide(filterWidget, 1000);
        });
    }
}

var sliderRange2 = document.querySelector("#slider-range-2");
if (sliderRange2) {
    var sliderValues2 = [75, 300];
    noUiSlider.create(sliderRange2, {
        start: sliderValues2,
        connect: true,
        range: {
            'min': 0,
            'max': 500
        }
    });
    var amount2 = document.getElementById('amount-2');
    sliderRange2.noUiSlider.on('update', function (values) {
        amount2.value = "$" + values[0] + " - $" + values[1];
    });

    var filterBtn2 = document.getElementById('filter-btn-2');
    if (filterBtn2) {
        filterBtn2.addEventListener('click', function () {
            var filterWidget = document.querySelector('.filter-widget');
            toggleSlide(filterWidget, 1000);
        });
    }
}

// filter widget toggle
var filterPopup = document.querySelector('.filter-popup');
var filterWidgetToggle = document.querySelector('.filter-widget-toggle');

if (filterPopup && filterWidgetToggle) {
    filterPopup.style.display = 'none';
    filterWidgetToggle.addEventListener('click', function () {
        toggleSlide(filterPopup, 500);
    });
}

// fixed sidebar
(function () {
    var setState = function () {
        if (length > yPos && width > xPos) {
            document.getElementById('sidebar-fluid').style.display = 'none';
            document.getElementById('sidebar-fixed').style.display = 'block';
        } else {
            document.getElementById('sidebar-fluid').style.display = 'block';
            document.getElementById('sidebar-fixed').style.display = 'none';
        }
    };

    var xPos = 683;
    var yPos = 240;

    var length = window.pageYOffset || document.documentElement.scrollTop;
    var width = window.innerWidth || document.documentElement.clientWidth;

    window.addEventListener('scroll', function () {
        length = window.pageYOffset || document.documentElement.scrollTop;
        setState();
    });

    window.addEventListener('resize', function () {
        width = window.innerWidth || document.documentElement.clientWidth;
        setState();
    });

})();

// price calculate
var priceCalculateBtn = document.querySelector('.price-calculate');
var calculateShippingBox = document.querySelector('.calculate-shipping-box');

if (priceCalculateBtn && calculateShippingBox) {
    priceCalculateBtn.addEventListener('click', function () {
        toggleSlide(calculateShippingBox, 500);
    });
}

/*-------------------------
  showlogin toggle function
--------------------------*/
var showLoginBtn = document.querySelector('#showlogin');
var checkoutLogin = document.querySelector('#checkout-sign-in');

if (showLoginBtn && checkoutLogin) {
    showLoginBtn.addEventListener('click', function () {
        toggleSlide(checkoutLogin, 900);
    });
}

/*-------------------------
  showcoupon toggle function
--------------------------*/
var showCouponBtn = document.querySelector('#showcoupon');
var checkoutCoupon = document.querySelector('#checkout_coupon');

if (showCouponBtn && checkoutCoupon) {
    showCouponBtn.addEventListener('click', function () {
        toggleSlide(checkoutCoupon, 900);
    });
}

/*-------------------------
  Create an account toggle function
--------------------------*/
var cbox = document.querySelector('#cbox');
var cboxInfo = document.querySelector('#cbox_info');

if (cbox && cboxInfo) {
    cbox.addEventListener('click', function () {
        toggleSlide(cboxInfo, 900);
    });
}

/*-------------------------
  Create an account toggle function
--------------------------*/
var shipBox = document.querySelector('#ship-box');
var shipBoxInfo = document.querySelector('#ship-box-info');

if (shipBox && shipBoxInfo) {
    shipBox.addEventListener('click', function () {
        toggleSlide(shipBoxInfo, 1000);
    });
}

// helper functions
function meanMenuInit() {
    var mobileMenu = document.querySelector('#mobile-menu');
    var meanMenuContainer = document.querySelector('.mobile-menu');
    if (mobileMenu && meanMenuContainer) {
        var meanScreenWidth = "992";
        var meanExpand = ">";
        var $ = jQuery;

        $(mobileMenu).meanmenu({
            meanMenuContainer: meanMenuContainer,
            meanScreenWidth: meanScreenWidth,
            meanExpand: meanExpand,
        });
    }
}

function onePageNavInit(topOffset) {
    var mainMenu = document.querySelector('.main-menu nav ul');
    if (mainMenu) {
        var currentClass = 'active';
        var scrollOffset = topOffset;
        var $ = jQuery;

        $(mainMenu).onePageNav({
            currentClass: currentClass,
            scrollOffset: scrollOffset,
        });
    }
}

function removeClass(element, className) {
    if (element && element.classList.contains(className)) {
        element.classList.remove(className);
    }
}

function addClass(element, className) {
    if (element && !element.classList.contains(className)) {
        element.classList.add(className);
    }
}

function mainSlider() {
    var basicSlider = document.querySelector('.slider-active');
    if (basicSlider) {
        var $ = jQuery;

        var $firstAnimatingElements = $('.single-slider:first-child').find('[data-animation]');
        doAnimations($firstAnimatingElements);

        $(basicSlider).on('beforeChange', function (e, slick, currentSlide, nextSlide) {
            var $animatingElements = $('.single-slider[data-slick-index="' + nextSlide + '"]').find('[data-animation]');
            doAnimations($animatingElements);
        });

        $(basicSlider).slick({
            autoplay: true,
            autoplaySpeed: 10000,
            dots: true,
            fade: true,
            arrows: false,
            responsive: [{
                breakpoint: 767,
                settings: {
                    dots: true,
                    arrows: false
                }
            }]
        });

        function doAnimations(elements) {
            var animationEndEvents = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
            elements.each(function () {
                var $this = $(this);
                var $animationDelay = $this.data('delay');
                var $animationType = 'animated ' + $this.data('animation');
                $this.css({
                    'animation-delay': $animationDelay,
                    '-webkit-animation-delay': $animationDelay
                });
                $this.addClass($animationType).one(animationEndEvents, function () {
                    $this.removeClass($animationType);
                });
            });
        }
    }
}

function owlCarouselInit(selector, options) {
    var element = document.querySelector(selector);
    if (element) {
        var $ = jQuery;
        $(element).owlCarousel(options);
    }
}

function magnificPopupInit(selector, options) {
    var elements = document.querySelectorAll(selector);
    if (elements.length > 0) {
        var $ = jQuery;
        $(elements).magnificPopup(options);
    }
}

function imagesLoadedInit(selector, callback) {
    var element = document.querySelector(selector);
    if (element) {
        imagesLoaded(element, callback);
    }
}

function toggleSlide(element, duration) {
    if (element.style.display === 'none') {
        element.style.display = 'block';
        slideDown(element, duration);
    } else {
        slideUp(element, duration, function () {
            element.style.display = 'none';
        });
    }
}

function slideDown(element, duration) {
    element.style.maxHeight = 'none';
    var height = element.offsetHeight;
    element.style.maxHeight = '0';
    element.style.opacity = '0';
    element.style.transitionProperty = 'max-height, opacity';
    element.style.transitionDuration = duration + 'ms';
    element.offsetHeight; // trigger a reflow, flushing the CSS changes
    element.style.maxHeight = height + 'px';
    element.style.opacity = '1';
}

function slideUp(element, duration, callback) {
    element.style.maxHeight = element.offsetHeight + 'px';
    element.style.opacity = '1';
    element.style.transitionProperty = 'max-height, opacity';
    element.style.transitionDuration = duration + 'ms';
    element.offsetHeight; // trigger a reflow, flushing the CSS changes
    element.style.maxHeight = '0';
    element.style.opacity = '0';

    setTimeout(callback, duration);
}
