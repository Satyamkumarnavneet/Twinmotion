# Twinmotion Image Blend and Animation Web Application

This project is a web application that allows users to upload two photos, blend them together, and animate the transition between the two images using Cloudinary. The final product allows users to see an animation of one image transitioning into another, such as a younger version of themselves transitioning into an older version.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Code Structure](#code-structure)
  - [Cloudinary Configuration](#cloudinary-configuration)
  - [Controller](#controller)
  - [Service](#service)
  - [HTML Templates](#html-templates)

## Prerequisites

- Java 11 or higher
- Maven
- Cloudinary account (API Key, API Secret, and Cloud Name)


### Code Structure (without actual code)
1. **CloudinaryConfig.java**: Defines the Cloudinary bean.
2. **ImageController.java**: Handles HTTP requests and interactions with the service layer.
3. **ImageService.java**: Contains the logic for image upload, blending, and animation creation.
4. **HTML Templates**: 
   - `src/main/resources/templates/index.html`: Form for image upload.
   - `src/main/resources/templates/result.html`: Displays the resulting animation.

