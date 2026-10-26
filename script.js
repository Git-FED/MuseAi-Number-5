const menuButton = document.querySelector(".menu-toggle");
const primaryNav = document.querySelector("#primary-nav");

if (menuButton && primaryNav) {
  menuButton.addEventListener("click", () => {
    const isOpen = menuButton.getAttribute("aria-expanded") === "true";
    menuButton.setAttribute("aria-expanded", String(!isOpen));
    primaryNav.classList.toggle("is-open", !isOpen);
  });

  primaryNav.addEventListener("click", (event) => {
    if (event.target instanceof HTMLAnchorElement) {
      menuButton.setAttribute("aria-expanded", "false");
      primaryNav.classList.remove("is-open");
    }
  });
}

const prefersReducedMotion = window.matchMedia?.("(prefers-reduced-motion: reduce)").matches ?? false;
const canReveal = !prefersReducedMotion && "IntersectionObserver" in window;

if (canReveal) {
  const revealTargets = document.querySelectorAll([
    ".hero-copy",
    ".hero-art",
    ".hero-ruler",
    ".section-heading",
    ".slot-card",
    ".decision-note",
    ".feature-pair > *",
    ".awake-layout > *",
    ".boundary-intro",
    ".boundary-artwork > *",
    ".group-layout > *",
    ".construction-section > *",
    ".hosting-layout > *",
    ".closing-heading",
    ".postcard-strip .promo-figure",
    ".footer-inner > *",
  ].join(","));

  const revealObserver = new IntersectionObserver((entries, observer) => {
    for (const entry of entries) {
      if (entry.isIntersecting) {
        entry.target.classList.add("is-visible");
        observer.unobserve(entry.target);
      }
    }
  }, { threshold: 0.12, rootMargin: "0px 0px -32px 0px" });

  revealTargets.forEach((element, index) => {
    element.classList.add("reveal");
    element.style.setProperty("--reveal-delay", `${(index % 5) * 75}ms`);
    revealObserver.observe(element);
  });

  document.documentElement.classList.add("motion-ready");
}

const communityGate = document.querySelector("#community-gate");
const countrySelect = document.querySelector("#eligible-country");
const ageConfirm = document.querySelector("#age-confirm");
const gateStatus = document.querySelector("#gate-status");
const matrixResult = document.querySelector("#matrix-result");
const matrixLink = document.querySelector("#matrix-link");

if (communityGate && countrySelect && ageConfirm && gateStatus && matrixResult && matrixLink) {
  const eligibleCountries = new Set(["Canada", "Switzerland", "Russia", "Iran", "Somalia", "Turkmenistan"]);

  communityGate.addEventListener("submit", (event) => {
    event.preventDefault();
    const country = countrySelect.value;
    if (!eligibleCountries.has(country) || !ageConfirm.checked) {
      gateStatus.textContent = "Select an eligible country and confirm that you are 18 or older.";
      matrixResult.hidden = true;
      matrixLink.removeAttribute("href");
      return;
    }

    gateStatus.textContent = "Thanks. This is self-attestation only and is not independently verified.";
    matrixLink.href = "https://matrix.to/#/#fed-os:matrix.org";
    matrixResult.hidden = false;
  });
}
