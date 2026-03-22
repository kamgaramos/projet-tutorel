# TODO - Projet Pharmacies Tutorel
Status: En cours - Phase 1 Backend Setup

## Phase 1: Backend Base (Auth, DB MySQL XAMPP)
✅ 0. Création TODO.md

## Tasks Phase 1 ✅ Backend Auth/DB
✅ 1.1-1.7: pom, configs, entities, DTOs, repos, services, controllers, security JWT/RBAC. Compile OK.

## Phase 2: CRUD Pharmacies/Produits/Ventes
- [ ] Repos/Entities extended
- [ ] Controllers (PHARMACIEN limited)
- [ ] Seed 4 pharmacies

## Phase 2: CRUD Users/Stock
- [ ] ...

## Phase 3: Prévisions IA (Python Prophet subprocess)
- [ ] Calcul dynamique pics/creux, suggestions

## Phase 4: Frontend Vite+React+TS

**Notes:**
- DB: MySQL XAMPP localhost:3306/projet_tutorel (créer DB/user si besoin).
- Prophet: Python subprocess (installer fbprophet localement).
- RBAC: Strict pharmacie_id check.

**Commande test après Phase 1:** `./mvnw spring-boot:run`
