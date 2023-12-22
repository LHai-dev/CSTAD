/** @type {import('tailwindcss').Config} */
module.exports = {

  content: [
    './src/pages/**/*.{js,ts,jsx,tsx,mdx}',
    './src/components/**/*.{js,ts,jsx,tsx,mdx}',
    './src/app/**/*.{js,ts,jsx,tsx,mdx}',
  ],
  theme: {
    extend: {
      backgroundImage: {
        'gradient-radial': 'radial-gradient(var(--tw-gradient-stops))',
        'gradient-conic':
          'conic-gradient(from 180deg at 50% 50%, var(--tw-gradient-stops))',
      },
      fontFamily:{
        "fontKonKhmer":['Konkhmer Sleokchher', "cursive"],
        "Noto Sans Khmer":['Noto Sans Khmer', "sans-serif",'Konkhmer Sleokchher'],
        "fontNoto":['Noto Sans Khmer', "sans-serif"],
        "Noto Sans Khmer":['Noto Sans Khmer', "sans-serif",'Noto Sans Khmer'],
      },
    },
  },
  plugins: [],
}
