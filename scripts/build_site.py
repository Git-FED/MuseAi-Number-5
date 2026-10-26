#!/usr/bin/env python3
"""Copy only the public landing-page files into dist/ for static hosting."""
from __future__ import annotations

import shutil
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
OUTPUT = ROOT / "dist"
FILES = (
    "index.html",
    "private-communities.html",
    "README.md",
    "404.html",
    "styles.css",
    "script.js",
    "favicon.svg",
    "manus-routes.json",
    "assets/icon.png",
    "assets/og-image.png",
    "assets/icon-source.svg",
)


def build() -> None:
    if OUTPUT.exists():
        shutil.rmtree(OUTPUT)
    OUTPUT.mkdir(parents=True)

    missing: list[str] = []
    for relative in FILES:
        source = ROOT / relative
        if not source.is_file():
            missing.append(relative)
            continue
        destination = OUTPUT / relative
        destination.parent.mkdir(parents=True, exist_ok=True)
        shutil.copy2(source, destination)

    for source in sorted((ROOT / "docs").glob("*.md")):
        destination = OUTPUT / "docs" / source.name
        destination.parent.mkdir(parents=True, exist_ok=True)
        shutil.copy2(source, destination)

    for source in sorted((ROOT / "promo").glob("*.png")):
        destination = OUTPUT / "promo" / source.name
        destination.parent.mkdir(parents=True, exist_ok=True)
        shutil.copy2(source, destination)

    expected_promos = [f"{number:02d}-" for number in range(1, 9)]
    promo_names = {path.name for path in (ROOT / "promo").glob("*.png")}
    for prefix in expected_promos:
        if not any(name.startswith(prefix) for name in promo_names):
            missing.append(f"promo/{prefix}*.png")

    if missing:
        shutil.rmtree(OUTPUT, ignore_errors=True)
        formatted = "\n".join(f"  - {item}" for item in missing)
        raise SystemExit(f"Cannot build static site; required source files are missing:\n{formatted}")

    import json

    routes = json.loads((OUTPUT / "manus-routes.json").read_text(encoding="utf-8"))
    if routes != {"routes": [{"path": "/", "title": "MuseAi Number 5"}, {"path": "/private-communities.html", "title": "Private Communities"}]}:
        shutil.rmtree(OUTPUT, ignore_errors=True)
        raise SystemExit("manus-routes.json must match the two-page static route manifest.")

    (OUTPUT / ".nojekyll").write_text("", encoding="utf-8")
    (OUTPUT / ".assetsignore").write_text(
        "_headers\n_redirects\n.assetsignore\n.nojekyll\n", encoding="utf-8"
    )
    (OUTPUT / "_headers").write_text(
        """/*
  X-Content-Type-Options: nosniff
  Referrer-Policy: strict-origin-when-cross-origin
  Permissions-Policy: camera=(), microphone=(), geolocation=()
  Content-Security-Policy: default-src 'self'; img-src 'self' data:; style-src 'self'; script-src 'self'; connect-src 'self'; frame-src https://discord.com; base-uri 'self'; form-action 'self'
/*.html
  Cache-Control: no-cache
/*.css
  Cache-Control: no-cache
/*.js
  Cache-Control: no-cache
/*.png
  Cache-Control: public, max-age=86400
/*.svg
  Cache-Control: public, max-age=86400
""",
        encoding="utf-8",
    )
    print(f"Built static site: {OUTPUT.relative_to(ROOT)}")


if __name__ == "__main__":
    build()
