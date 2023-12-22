import Layout from '../components/layout'
import { motion } from 'framer-motion'

export default function About() {
  return (
    <Layout>
      <motion.div
        key="about"
        initial={{ opacity: 0 }}
        animate={{ opacity: 1 }}
        transition={{ duration: 0.5, delay: 0.2 }}
        className="px-4"
      >
        <div className="mb-6 text-center text-gray-800 dark:text-white">
          Hi, I'm LimHai! I am a JUNIOR BACKEND DEVELOPERS at Developers Cambodia with a passion for developing web and mobile
          applications that make a positive impact on peoples lives.
        </div>
        <div className="text-center text-gray-800 dark:text-white">
          In addition to coding and learning new tech, I enjoy Football or Soccer, drinking coffee,
          playing guitar, reading, and hanging with my dog. If any of these things interest you too,
          I'd love to chat!
        </div>
        <div className="text-center text-gray-800 dark:text-white">
          Can Ask Me ABout Spring Framework , Microservice And  Web Design...
        </div>
      </motion.div>
    </Layout>
  )
}
