document.addEventListener("DOMContentLoaded", function () {
    const animatedImage = document.getElementById("animated-image");
    if (animatedImage) {
        animatedImage.style.transition = "opacity 2s";
        animatedImage.style.opacity = 0;
        setTimeout(() => {
            animatedImage.style.opacity = 1;
        }, 100);
    }
});
