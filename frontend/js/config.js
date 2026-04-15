// ==============================================
// API Configuration
// Change ONLY this URL when backend is deployed
// ==============================================

const API_BASE_URL = window.location.hostname === "localhost" || window.location.hostname === "127.0.0.1"
    ? "http://localhost:8080"   // Local development
    : "https://farm-to-door-production.up.railway.app"; // Railway backend (live)

// Usage in your JS: fetch(`${API_BASE_URL}/api/auth/login`, { ... })
