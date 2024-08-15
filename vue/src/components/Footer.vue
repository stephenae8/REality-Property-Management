<template>
    <footer id="footer">
      <div class="footer-content">
        <div class="main-info">

          <h1>A2DS2 Reality Site</h1>
          <div class="social-icons">
            <a href="#" aria-label="Facebook"><img src="../img/socialMediaHandle/icons8-facebook-100.png" alt="Facebook"></a>
            <a href="#" aria-label="Instagram"><img src="../img/socialMediaHandle/icons8-instagram-100.png" alt="Instagram"></a>
            <a href="#" aria-label="LinkedIn"><img src="../img/socialMediaHandle/icons8-linkedin-100.png" alt="LinkedIn"></a>
            <a href="#" aria-label="TikTok"><img src="../img/socialMediaHandle/icons8-tiktok-100.png" alt="TikTok"></a>
            <a href="#" aria-label="Twitter"><img src="../img/socialMediaHandle/icons8-twitterx-100.png" alt="Twitter"></a>
            <a href="#" aria-label="YouTube"><img src="../img/socialMediaHandle/icons8-youtube-100.png" alt="YouTube"></a>
            <a href="#" aria-label="About Us"><img src="../img/socialMediaHandle/icons8-about-us-100.png" alt="About Us"></a>

          </div>
        </div>
        
        <div class="footer-links">
          <router-link to="/about">About Us</router-link>
          <router-link to="/contact">Contact Us</router-link>
          <router-link to="/legal">Legal Notices</router-link>
          <router-link to="/privacy">Private Notice</router-link>
          <router-link to="/scams">Avoid Scams</router-link>
        </div>
        
        <div class="footer-bottom">
          <p class="equal-housing">Equal Housing Opportunity</p>
          <p class="copyright">&copy;2024 Tech Elevator Inc.</p>
        </div>
      </div>
    </footer>
  </template>
  
  <script>
  export default {
   
  }
  </script>
  
  <style scoped>
  #footer {
    background-color: lightgray;
    padding: 1rem;
    color: #333;
  }
  
  .footer-content {
    display: flex;
    flex-direction: column;
    align-items: center;
    text-align: center;
    max-width: 1200px;
    margin: 0 auto;
  }
  
  .main-info {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 1rem;
  }
  
  .main-info h1 {
    font-size: 1.5rem;
    margin-bottom: 0.5rem;
  }
  
  .social-icons {
    display: flex;
    justify-content: center;
    gap: 0.5rem;
    margin-bottom: 1rem;
  }
  
  .social-icons img {
    width: 25px;
    height: 25px;
    transition: transform 0.3s ease;
  }
  
  .social-icons img:hover {
    transform: scale(1.1);
  }
  
  .footer-links {
    display: flex;
    gap: 1rem;
    margin-bottom: 1rem;
  }
  
  .footer-links a {
    color: black;
    text-decoration: none;
  }
  
  .footer-links a:hover {
    text-decoration: underline;
  }
  
  .footer-bottom {
    display: flex;
    flex-direction: column;
    align-items: center;
  }
  
  .equal-housing {
    font-style: italic;
    margin-bottom: 0.5rem;
  }
  
  .copyright {
    font-weight: 700;
  }
  
  @media (max-width: 768px) {
    .social-icons img {
      width: 20px;
      height: 20px;
    }
  
    .main-info h1 {
      font-size: 1.25rem;
    }
  
    .footer-links {
      flex-direction: column;
      gap: 0.5rem;
    }
  }
  </style>
  