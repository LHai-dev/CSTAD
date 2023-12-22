import Head from 'next/head'
import Image from 'next/image'
import { Inter } from 'next/font/google'
import Slider from '@/components/Slider'
import NavBarComponent from '@/components/NavBarComponent'
import Layout from '@/components/Layout'

const inter = Inter({ subsets: ['latin'] })

export default function Home() {
  return (
    <>
    <NavBarComponent/>
    <Slider/>
    </>
  )
}
