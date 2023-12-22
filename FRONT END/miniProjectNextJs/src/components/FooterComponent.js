import React from 'react'

export default function FooterComponent() {
  return (
<footer class="py-20 lg:py-32 font-medium text-gray-500 border-top">
  <div class="container">
    <div class="row">
      <div class="col-12 col-md-6 col-lg-3">
        <p>© 2023lim_hai.</p>
        <p class="mt-1 text-sm">All content of this website is distributed under the
          <a href="https://creativecommons.org/licenses/by-nc/4.0/" target="_blank" rel="noreferrer" class="text-black underline hover-text-gray-500">CC BY-NC license</a>.</p>
      </div>
      <div class="col-6 col-md-3 col-lg-2 offset-lg-4">
        <ul class="list-unstyled text-md-right">
          <li><a class="py-1 d-block text-decoration-none hover-text-black" href="/">Home</a></li>
          <li><a class="py-1 d-block text-decoration-none hover-text-black" href="/introduct">Blog</a></li>
          <li><a href="/blog/rss.xml" target="_blank" rel="noreferrer" class="py-1 d-block text-decoration-none hover-text-black">RSS</a></li>
        </ul>
      </div>
      <div class="col-6 col-md-3 col-lg-2">
        <ul class="list-unstyled text-md-right">
          <li><a href="https://twitter.com/kettanaito" target="_blank" rel="noreferrer" class="py-1 d-block text-decoration-none hover-text-black">Twitter</a></li>
          <li><a href="https://github.com/hai172212" target="_blank" rel="noreferrer" class="py-1 d-block text-decoration-none hover-text-black">GitHub</a></li>
          <li><a href="https://www.facebook.com/ahhai12345" target="_blank" rel="noreferrer" class="py-1 d-block text-decoration-none hover-text-black">FaecBook</a></li>
        </ul>
      </div>
    </div>
  </div>
</footer>


  )
}
