<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>
      SpaceHub WorkSpace Management
    </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/spacehub.css" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"/>
  
  </head>
  <body>
    <section class="header">
      <div class="container">
      	
        <img src="${pageContext.request.contextPath}/resources/image/SpaceHub3.png">
        <button type="button" class="home-btn">Home</button>
        <button type="button" class="about-btn">About Us</button>
        <button type="button" class="locate-btn">Locate Us</button>
        <button type="button" class="customer-btn">Support</button>
     </div>
     <h1>SpaceHub Co-Work Space</h1>
     <p>Getting a Workspace Is a Click Away</p>
     <div class="input-group">
         <input type="text" class="form-control" placeholder="Search for Co-Work Space">
         <div class="input-group-append">
            <button type="submit" class="input-group-text btn">Search</button>
         </div>
     </div>
    </section>
    <section>
        <h1>Featured Space</h1>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="feature-box">
                        <div class="feature-img">
                            <img src="${pageContext.request.contextPath}/resources/image/coworking1.jpg">
                            <div class="price">
                                <p>N5,000</p>
                            </div>
                            <div class="rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                
                            </div>
                        </div>
                        <div class="feature-details">
                          <h4>Deluxe Package</h4>
                          <p>Our Deluxe Package is tailor-made for Entrepreneurs on a tight budget, it comes with a flexible space plan.</p>
                          <div>
                            <span><i class="fa fa-map-marker"></i>Lagos</span>
                            <span><i class="fa fa-sun-o"></i>7 Days</span>
                            <span><i class="fa fa-moon-o"></i>2 Weekends</span>
                          </div>

                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                  <div class="feature-box">
                    <div class="feature-img">
                        <img src="${pageContext.request.contextPath}/resources/image/coworking2.jpg">
                        <div class="price">
                            <p>N10,000</p>
                        </div>
                        <div class="rating">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star-half-o"></i>
                        </div>
                    </div>
                    <div class="feature-details">
                      <h4>Gold Package</h4>
                      <p>Our Gold Package is tailor-made for Entrepreneurs with great panache, it comes with a personal entertainment system.</p>
                      <div>
                        <span><i class="fa fa-map-marker"></i>Lagos</span>
                        <span><i class="fa fa-sun-o"></i>7 Days</span>
                        <span><i class="fa fa-moon-o"></i>2 Weekends</span>
                      </div>

                    </div>
                </div>
                </div>
                <div class="col-md-4">
                  <div class="feature-box">
                    <div class="feature-img">
                        <img src="${pageContext.request.contextPath}/resources/image/coworking3.png">
                        <div class="price">
                            <p>N15,000</p>
                        </div>
                        <div class="rating">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                        </div>
                    </div>
                    <div class="feature-details">
                      <h4>Platinum Package</h4>
                      <p>Our Platinum Package is tailor-made for Entrepreneurs with taste for exclusive work atmosphere, it comes with a serene and spacious cubicle.</p>
                      <div>
                        <span><i class="fa fa-map-marker"></i>Lagos</span>
                        <span><i class="fa fa-sun-o"></i>7 Days</span>
                        <span><i class="fa fa-moon-o"></i>2 Weekends</span>
                      </div>

                    </div>
                </div>
                </div>

            </div>
        </div>
    </section>
    <section class="gallery">
      <h1>Co-Working Space Gallery</h1>
      <div class="container">
        <div class="row">
          <div class="col-md-3">
            <div class="gallery-box">
              <img src="${pageContext.request.contextPath}/resources/image/banner1.jpg">
	            <h4>Conference</h4>
            </div>
          </div>
          <div class="col-md-3">
            <div class="gallery-box">
              <img src="${pageContext.request.contextPath}/resources/image/library.jpg">
	            <h4>Library</h4>
            </div>
          </div>
          <div class="col-md-3">
            <div class="gallery-box">
              <img src="${pageContext.request.contextPath}/resources/image/lounge.jpg">
	            <h4>Lounge</h4>
            </div>
          </div>
          <div class="col-md-3">
            <div class="gallery-box">
              <img src="${pageContext.request.contextPath}/resources/image/reception.jpg">
	            <h4>Reception</h4>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section class="banner">
      <div class="banner-highlights">
        <div class="container">
          <div class="row">
            <div class="col-md-8">
              <h2>Get 30% on SpaceHub Co-Work Space</h2>
              <p>Book your space before 31st January and enjoy a 30% flat discount.</p>
            </div>
            <div class="col-md-4">
              <button type="button" class="booking-btn">Book Now</button>
            </div>
          </div>

        </div>

      </div>

    </section>
    <section class="users-feedback">
      <h1>Users Review</h1>
      <div class="container">
        <div class="row">
          <div class="col-md-4">
            <div class="user-review">
              <p>SpaceHub provides the best co-work space in Lagos, it was an experience to savor, this is the place to be. </p>
              <h5>Abel Annabel</h5>
              <small>Lekki</small>
            </div>
            <img src="${pageContext.request.contextPath}/resources/image/lady4.jpg">
          </div>
          <div class="col-md-4">
            <div class="user-review">
              <p>SpaceHub and my company are a match made from heaven, they are the best at what they do, kudos to the management. </p>
              <h5>Martins Johnson</h5>
              <small>Ikoyi</small>
            </div>
            <img src="${pageContext.request.contextPath}/resources/image/man2.jpg">
          </div>
          <div class="col-md-4">
            <div class="user-review">
              <p>Midas Touch of the highest order, SpaceHub is the idea co-work space for any serious Entrepreneur, The Best by far.</p>
              <h5>Farida Usman</h5>
              <small>VGC</small>
            </div>
            <img src="${pageContext.request.contextPath}/resources/image/lady5.jpg">
          </div>
        </div>
      </div>
    </section>
    <section class="footer">
      <div class="container">
        <div class="row">
          <div class="col-md-3">
            <img src="${pageContext.request.contextPath}/resources/image/SpaceHub3.png" class="footer-logo">
            <p>SpaceHub is poised to provide Entrepreneurs the right platform to perform, providing a serene and suitable co-work space.  </p>
          </div>
          <div class="col-md-3">
            <h4>Features</h4>
            <p>Deals & Offers</p>
            <p>Customers Review</p>
            <p>Cancellation Policy</p>
          </div>
          <div class="col-md-3">
            <h4>Quick Contact</h4>
            <p><i class="fa fa-phone-square"></i> +2348030000001</p>
            <p><i class="fa fa-envelope"></i> enquiry@spacehub.com</p>
            <p><i class="fa fa-home"></i> SpaceHub Drive, MD Avenue, Banana Island, Lagos</p>
          </div>
          <div class="col-md-3">
            <h4>Follow Us On</h4>
            <p><i class="fa fa-facebook-official"></i> SpaceHub</p>
            <p><i class="fa fa-youtube-play"></i> SpaceHub</p>
            <p><i class="fa fa-twitter"></i> SpaceHub</p>
          </div>
        </div><hr>
        <p class="copyright">Made with <i class="fa fa-heart"></i>by SpaceHub RAD</p>
      </div>

    </section>
  </body>
</html>