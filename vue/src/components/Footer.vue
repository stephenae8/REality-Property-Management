<template>
    <footer id="footer">
      <div class="footer-content">
        <div class="main-info">
          <h4 class="company-name">A2DS2.com</h4>
          <p class="copyright">&copy;2024 DreamStar Group, Inc.</p>
          <div class="social-icons">
            <a href="#"><img src="../img/socialMediaHandle/icons8-facebook-100.png" alt="Facebook"></a>
            <a href="#"><img src="../img/socialMediaHandle/icons8-instagram-100.png" alt="Instagram"></a>
            <a href="#"><img src="../img/socialMediaHandle/icons8-linkedin-100.png" alt="LinkedIn"></a>
            <a href="#"><img src="../img/socialMediaHandle/icons8-tiktok-100.png" alt="TikTok"></a>
            <a href="#"><img src="../img/socialMediaHandle/icons8-twitterx-100.png" alt="Twitter"></a>
            <a href="#"><img src="../img/socialMediaHandle/icons8-youtube-100.png" alt="YouTube"></a>
            <a href="#"><img src="../img/socialMediaHandle/icons8-about-us-100.png" alt="About Us"></a>
          </div>
          <p class="equal-housing">Equal Housing Opportunity</p>
        </div>
        <div class="footer-links">
          <div class="footer-section">
            <h4>Advertiser</h4>
            <router-link to="">Advertise</router-link>
            <router-link to="">Customer Portal</router-link>
            <router-link to="">Community Voice</router-link>
          </div>
          <div class="footer-section">
            <h4>About Us</h4>
            <router-link to="">About Us</router-link>
            <router-link to="">Contact Us</router-link>
            <router-link to="">Legal Notices</router-link>
            <router-link to="">Private Notice</router-link>
            <router-link to="">Avoid Scams</router-link>
          </div>
          <div class="footer-section">
            <h4>City</h4>
            <router-link to="#">New York</router-link>
            <router-link to="#">Philadelphia</router-link>
            <router-link to="#">Austin</router-link>
            <router-link to="#">Tulsa</router-link>
            <router-link to="#">Atlanta</router-link>
            <router-link to="#">New Jersey</router-link>
          </div>
        </div>
      </div>
    </footer>
  </template>
  
  <script>
  export default {
    name: 'Footer'
  }
  </script>
  
  <style scoped>
  #footer {
    background-color: lightgray;
    padding: 2rem;
  }
  
  .footer-content {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
  }
  
  .main-info {
    flex: 1 1 100%;
    text-align: center;
    margin-bottom: 2rem;
  }
  
  .company-name {
    font-size: 2.5rem;
    font-family: 'Times New Roman', Times, serif;
    margin-bottom: 0.5rem;
  }
  
  .copyright {
    font-weight: 700;
    margin-bottom: 1rem;
  }
  
  .social-icons {
    display: flex;
    justify-content: center;
    gap: 1rem;
    margin-bottom: 1rem;
  }
  
  .social-icons img {
    width: 30px;
    height: auto;
  }
  
  .equal-housing {
    font-style: italic;
  }
  
  .footer-links {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    width: 100%;
    text-align: center;
  }
  
  .footer-section {
    flex: 1 1 200px;
    margin-bottom: 1rem;
  }
  
  .footer-section h4 {
    font-size: 1.1rem;
    font-weight: bold;
    margin-bottom: 0.5rem;
  }
  
  .footer-section a {
    display: block;
    color: black;
    text-decoration: none;
    margin-bottom: 0.3rem;
  }
  
  @media (min-width: 768px) {
    .main-info {
      flex: 0 1 25%;
      text-align: left;
    }
  
    .footer-links {
      flex: 0 1 70%;
    }
  }
  
  @media (max-width: 480px) {
    .social-icons img {
      width: 25px;
    }
  
    .company-name {
      font-size: 2rem;
    }
  }
  </style>