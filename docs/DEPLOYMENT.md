# Static-site deployment

The Android project and static site share one Git repository. The website source stays at the repository root; `python3 scripts/build_site.py` copies only the public HTML pages, CSS, JavaScript, favicon, docs, and promotional images into `dist/`. Do not point a static host at the repository root: that would expose Android source and build metadata as downloadable website files.

## GitHub Pages

The included `.github/workflows/deploy-site.yml` builds `dist/` and deploys it with GitHub Actions when changes are pushed to `main`. In the repository’s **Settings → Pages**, select **GitHub Actions** as the publishing source. The workflow does not require a Node dependency install or private secret.

The site uses relative asset links so it can be served from a GitHub Pages project URL such as `/MuseAi-Number-5/`. Replace the example Open Graph image host in `index.html` with the real public site origin if social previews are needed. The repository URL mentioned in the original tree is `https://github.com/Git-FED/MuseAi-Number-5`; confirm its ownership and existence before treating it as live.

The static output includes `private-communities.html` and its declared page route. The FED-OS Matrix step is only a client-side courtesy gate; it cannot enforce age or residency rules. The Discord embed is the only external frame origin permitted by the generated Content Security Policy (`https://discord.com`).

## Cloudflare Pages from GitHub

Connect the repository in Cloudflare **Workers & Pages → Create application → Pages → Connect to Git**. Choose the production branch (normally `main`), leave the framework preset unset, use `python3 scripts/build_site.py` as the build command, and set the build output directory to `dist`. The script uses only the Python standard library; no secrets or database are needed. Cloudflare Pages consumes the `_headers` file produced in `dist/` for response headers.

Cloudflare also supports Direct Upload. Create a Pages project once, then run:

```sh
python3 scripts/build_site.py
npx wrangler pages deploy dist --project-name museai-number-five
```

Wrangler requires an authenticated Cloudflare account. Direct Upload and Git integration are distinct project setup choices; decide which one you want when creating the Pages project. The optional `.github/workflows/deploy-cloudflare.yml` is manual (`workflow_dispatch`) and requires the owner to add `CF_API_TOKEN` and `CF_ACCOUNT_ID` secrets. Choose `pages` as the deployment target and set `CF_PAGES_PROJECT` if the project name differs.

## Cloudflare Workers static assets

The alternative Worker static-assets deployment uses `wrangler.jsonc` and `src/worker.js`. Build first, authenticate Wrangler, then run:

```sh
python3 scripts/build_site.py
npx wrangler deploy
```

`wrangler.jsonc` points only to `dist/`. Static file requests are forwarded through the asset binding and receive basic security headers. No application API, login, database, relay endpoint, or secret is included. The Worker deployment workflow is also manual and uses the same Cloudflare credentials; select `worker` as the target.

Use Pages or Workers as the canonical site host rather than attempting to turn GitHub Pages into a hidden origin behind an unreviewed proxy. The included GitHub Pages workflow is a separate optional deployment. Hosting configuration files are prepared, but no accounts were connected and no site was published in creating this repository.

## Platform references

- [GitHub Pages publishing sources](https://docs.github.com/en/pages/getting-started-with-github-pages/configuring-a-publishing-source-for-your-github-pages-site)
- [Cloudflare Workers Static Assets](https://developers.cloudflare.com/workers/static-assets/)
- [Workers asset bindings and configuration](https://developers.cloudflare.com/workers/static-assets/binding/)
- [Cloudflare Pages Direct Upload](https://developers.cloudflare.com/pages/get-started/direct-upload/)
- [Cloudflare Pages build configuration](https://developers.cloudflare.com/pages/configuration/build-configuration/)
