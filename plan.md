# MuseAi-Number-5 — Build Plan

## Scope and implementation approach

Create a downloadable GitHub-ready repository based on the supplied 73-file contract. It will contain an Android Gradle/Kotlin application scaffold with five numbered agent slots and a sixth Group tab, a static promotional landing page, the named docs/prompts/testing assets, eight individual comic-style promo illustrations, icon/OG artwork, and deployment configuration for both GitHub Pages and Cloudflare Pages/Workers. Add necessary, clearly documented hosting and favicon files beyond the original 73-file count.

The Android sources will be coherent starter code rather than a falsely certified release: slot 1 is labeled Muse; slots 2–5 remain unassigned; sample flows and reports are explicitly unrun; group relay settings contain placeholders only; signing credentials are excluded. Isolation and release claims will be qualified in docs, and unresolved D1/D4/D11/D13 decisions or validation gates will be visible rather than represented as proven behavior. Include Android debug CI and checks; a debug APK may be built separately, but no generated APK or signing keystore goes in the source ZIP.

The landing page is a dependency-free, responsive static HTML/CSS/JS page using relative asset paths so it works at a GitHub Pages project subpath as well as a custom-domain root. Its visual treatment is a darker, muted editorial-comic workshop: charcoal surfaces, warm off-white copy, and a restrained burnt-orange brand accent with softened secondary colors. Keep strong contrast, accessible responsive navigation, visible short scroll reveals, a gentle hero-art float and a small animated status mark, all disabled or reduced when `prefers-reduced-motion` is requested; content must remain visible if JavaScript or IntersectionObserver is unavailable. Include metadata, direct repo/download links that remain placeholders until a URL exists, a linked SVG favicon, and sections for the product, five slots, Group, limitations, promo artwork, and deployment. GitHub Actions will publish the static page; Cloudflare configuration will support Pages/Workers static assets from the repository with cache/security headers and setup instructions. No hosting account, GitHub repository, domain, or Cloudflare service will be changed or published as part of this file-generation task.

The repository structure will preserve the provided paths: root Gradle and project files; `app/src/main` Android assets, Kotlin package, and XML resources; root `assets/`; `promo/`; `docs/`; `prompts/`; `testing/`; and `.github/workflows/`. Additional root/site deployment files and this Webdev plan/ToDo may be included and documented.

## Design

Three plausible directions (sampled low-probability alternatives): utilitarian Android documentation (0.04); glossy AI startup gradient (0.03); hand-inked workplace-comic zine (0.07). Choose the hand-inked workplace-comic zine direction, now interpreted in a darker workshop palette.

**Design Movement:** contemporary editorial comic with deadpan workplace humor, chunky imperfect outlines, and restrained halftone accents.

**Core Principles:** explain the five-slot idea quickly; make the open lineup decision conspicuous; keep controls and reading order obvious; let humor decorate rather than obscure technical caveats.

**Color Philosophy:** matte charcoal and deep slate create a calmer workshop-like canvas; warm paper-colored text protects legibility; burnt orange gives Muse a distinctive ember accent; muted violet, teal, and lichen are supporting colors, not assignments for slots 2–5.

**Layout Paradigm:** an editorial scroll with an off-center hero, alternating wide narrative bands, and a compact horizontal slot strip that collapses naturally on small screens rather than a generic centered dashboard grid.

**Signature Elements:** hand-drawn numbered slot chips; a small deadpan mascot/robot; comic-panel promo cards with speech-bubble-like captions.

**Interaction Philosophy:** plain links and buttons with clear focus states, reduced-motion support, and no interaction needed to understand the content.

**Animation:** staggered, short scroll-reveal entrances for narrative panels; a very gentle hero illustration drift and small status/badge motion lend life without feeling like a bright startup landing page; disable movement and smooth scrolling under `prefers-reduced-motion`; keep every section visible when script/observer support is absent.

**Typography System:** system sans-serif for body and UI, with a bold condensed system fallback for headlines; avoid externally hosted fonts so the site remains self-contained and robust on GitHub Pages.

**Brand Essence:** five separate AI workspaces, one Android shell, with a Group tab alongside them; practical, candid, wry.

**Brand Voice:** dry, friendly one-liners that never imply unverified security or availability. Examples: “Five tabs. One phone. Nobody has to borrow your cookies.” and “Slots 2–5 are still wearing paper name tags.”

**Wordmark & Logo:** a compact five-stripe mark with a single warm burnt-orange stripe and four neutral stripes; source it as editable SVG and use it for the favicon/app icon.

**Signature Brand Color:** Muse burnt orange `#D47C50`.

## Build and delivery

Keep production static files at the repository root for Pages compatibility. Make the Cloudflare Wrangler configuration point to that static root and describe both dashboard-connected Pages setup and `wrangler pages deploy`/Workers static-asset use. The site must not require a Node build step. Keep all secrets out of source; all example credentials are visibly fake placeholders. Zip the finished repository while excluding `.git`, Gradle build/cache output, generated signing material, and the archive itself.
