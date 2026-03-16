# Digital SmartSoil - Android Implementation Plan (Java)

## 📱 Project Overview
Converting the React/Vite web app to **Native Android (Java)** while maintaining the same UI/UX design and functionality.

---

## 🎨 DESIGN SYSTEM MAPPING

### Color Palette
```
Primary Green:     #2D5016 (HSL: 142 40% 32%)
Secondary Brown:   #52785A (HSL: 32 45% 50%)
Accent Gold:       #D4AF37 (HSL: 45 80% 55%)
Status Low:        #FF6B6B (Red)
Status Medium:     #FFC107 (Yellow/Gold)
Status High:       #4CAF50 (Green)
Light Bg:          #F5F5F5
Card Bg:           #FFFFFF (with 80% alpha)
Text Dark:         #212121
Text Light:        #757575
```

### Typography
- **Display Font**: Outfit (Bold, SemiBold, Regular)
- **Body Font**: DM Sans (Medium, Regular)
- **Sizes**: 12sp, 14sp, 16sp, 18sp, 20sp, 24sp, 28sp, 32sp

### Components
- Glass Card Style: 80% opacity background + blur effect
- Border Radius: 12dp (0.75rem)
- Shadows: Elevation 4-8dp
- Animations: fade-in (300ms), scale-in (300ms), slide-up (400ms), grow (800ms)

---

## 📲 PAGE MAPPING (Web → Android)

| Web Route | Android Screen | Activity/Fragment | Type |
|-----------|----------------|------------------|------|
| / | Splash | SplashActivity | Activity |
| /login | Login | LoginActivity | Activity |
| /register | Register | RegisterActivity | Activity |
| /forgot-password | Forgot Password | ForgotPasswordActivity | Activity |
| /reset-password | Reset Password | ResetPasswordActivity | Activity |
| /dashboard | Dashboard | MainActivity + DashboardFragment | Activity + Fragment |
| /add-farm | Add Farm | AddFarmActivity/Dialog | Activity/Dialog |
| /soil-test | Soil Test | SoilTestActivity/Fragment | Activity/Fragment |
| /history | History | HistoryActivity/Fragment | Activity/Fragment |
| /profile | Profile | ProfileActivity/Fragment | Activity/Fragment |
| /about | About | AboutActivity/Fragment | Activity/Fragment |
| /how-to-use | How to Use | HowToUseActivity/Fragment | Activity/Fragment |
| /contact | Contact | ContactActivity/Fragment | Activity/Fragment |

---

## 🏗️ ANDROID ARCHITECTURE

### Tech Stack
```
Language:              Java 11+
Build System:          Gradle (Kotlin DSL)
Min SDK:               API 24 (Android 7.0)
Target SDK:            API 36 (Android 15)
Architecture Pattern:  MVVM + Repository
UI Framework:          AndroidX Material Design 3
Networking:            Retrofit 2 + OkHttp
Database:              Room (local cache) + Supabase (remote)
Image Loading:         Glide
Charts:                MPAndroidChart (like Recharts)
PDF Generation:        iTextPDF or Android Print Framework
Location:              Fused Location Provider (Google Play Services)
Weather API:           Open-Meteo (HTTP)
```

### Project Structure
```
app/src/main/
├── java/com/digitalsmartsoil/
│   ├── ui/
│   │   ├── activity/
│   │   │   ├── SplashActivity.java
│   │   │   ├── LoginActivity.java
│   │   │   ├── RegisterActivity.java
│   │   │   ├── ForgotPasswordActivity.java
│   │   │   ├── ResetPasswordActivity.java
│   │   │   ├── MainActivity.java (main container)
│   │   │   ├── AddFarmActivity.java
│   │   │   ├── SoilTestActivity.java
│   │   │   ├── HistoryActivity.java
│   │   │   ├── ProfileActivity.java
│   │   │   ├── AboutActivity.java
│   │   │   ├── HowToUseActivity.java
│   │   │   ├── ContactActivity.java
│   │   │   └── NotFoundActivity.java
│   │   ├── fragment/
│   │   │   ├── DashboardFragment.java
│   │   │   ├── SoilTestFragment.java
│   │   │   ├── HistoryFragment.java
│   │   │   └── ProfileFragment.java
│   │   ├── adapter/
│   │   │   ├── FarmAdapter.java
│   │   │   ├── SoilTestHistoryAdapter.java
│   │   │   └── CropRecommendationAdapter.java
│   │   ├── view/
│   │   │   ├── GlassCardView.java
│   │   │   ├── ProgressParameterView.java (animated progress bars)
│   │   │   ├── WeatherWidgetView.java
│   │   │   └── FarmWeatherComponent.java
│   │   └── dialog/
│   │       ├── EditFarmDialog.java
│   │       ├── DeleteFarmDialog.java
│   │       └── PredictionLoadingDialog.java
│   │
│   ├── viewmodel/
│   │   ├── AuthViewModel.java
│   │   ├── DashboardViewModel.java
│   │   ├── SoilTestViewModel.java
│   │   ├── HistoryViewModel.java
│   │   └── ProfileViewModel.java
│   │
│   ├── repository/
│   │   ├── AuthRepository.java
│   │   ├── FarmRepository.java
│   │   ├── SoilTestRepository.java
│   │   ├── ProfileRepository.java
│   │   └── WeatherRepository.java
│   │
│   ├── model/
│   │   ├── User.java
│   │   ├── Profile.java
│   │   ├── Farm.java
│   │   ├── SoilTest.java
│   │   ├── SoilTestResult.java
│   │   ├── WeatherData.java
│   │   ├── CropRecommendation.java
│   │   └── AuthResponse.java
│   │
│   ├── api/
│   │   ├── SupabaseClient.java
│   │   ├── SupabaseAuthApi.java
│   │   ├── SupabaseDbApi.java
│   │   ├── SupabaseStorageApi.java
│   │   └── OpenMeteoWeatherApi.java
│   │
│   ├── database/
│   │   ├── AppDatabase.java
│   │   ├── dao/
│   │   │   ├── FarmDao.java
│   │   │   ├── SoilTestDao.java
│   │   │   └── ProfileDao.java
│   │   └── entity/
│   │       ├── FarmEntity.java
│   │       ├── SoilTestEntity.java
│   │       └── ProfileEntity.java
│   │
│   ├── util/
│   │   ├── Constants.java
│   │   ├── SessionManager.java
│   │   ├── SoilPredictionEngine.java (mock ML logic)
│   │   ├── CropRecommendationEngine.java
│   │   ├── StatusColorHelper.java
│   │   ├── DateFormatter.java
│   │   ├── LocationUtils.java
│   │   ├── ImageProcessor.java
│   │   └── PdfGenerator.java
│   │
│   ├── auth/
│   │   └── AuthContext.java (Auth state holder)
│   │
│   └── App.java (Application class)
│
├── res/
│   ├── layout/ (45+ XML files)
│   ├── drawable/ (SVG/PNG icons + custom drawables)
│   ├── values/
│   │   ├── colors.xml
│   │   ├── themes.xml
│   │   ├── strings.xml
│   │   ├── dimens.xml
│   │   ├── styles.xml
│   │   └── attrs.xml
│   ├── values-night/ (dark theme)
│   ├── anim/ (animations)
│   ├── menu/ (bottom nav, options menus)
│   └── raw/ (static assets)
│
├── AndroidManifest.xml
└── build.gradle.kts
```

---

## 📋 DETAILED FEATURE BREAKDOWN

### 1. AUTHENTICATION FLOW

#### LoginActivity
```
UI Elements:
- Gradient-hero background (green to golden)
- Centered glass-card (80% opacity + blur)
- Sprout icon (circular, green background)
- Google OAuth button (with Google SVG)
- "or" separator
- Email input | Mail icon
- Password input | Lock icon
- Login button
- "Forgot password?" link
- "New user? Register" link

Functionality:
- Email/password login via Supabase
- Google OAuth (implement via Firebase)
- Input validation
- Error toast notifications
- Loading state (circular progress)
- Auto-redirect to dashboard if already logged in
```

#### RegisterActivity
```
UI Elements:
- Same glass-card layout as login
- Full Name input
- Email input
- Gender select (Male/Female/Other)
- Mobile (optional) input
- Password input (min 6 chars)
- Confirm Password input
- Register button

Functionality:
- Form validation
- Supabase signUp with metadata
- Trigger: Auto-create profile in DB
- Error handling (duplicate email, weak password)
- Success → auto-login → dismiss to dashboard
- Link to login page
```

#### ForgotPasswordActivity
```
UI Elements:
- Glass-card layout
- Email input
- Send Reset Link button

Functionality:
- Send password reset email via Supabase
- Show confirmation message
- Auto-dismiss after 3 seconds or show "Back to Login" button
- Toast notification
```

#### ResetPasswordActivity
```
Functionality:
- Listen for deep link from Supabase reset email
- Parse reset token from Intent
- Show new password + confirm password fields
- Validate passwords (min 6 chars, match)
- Update password via Supabase
- Redirect to login on success
```

---

### 2. MAIN APP LAYOUT

#### MainActivity (with AppLayout)
```
Components:
- AppBarLayout with gradient-earth background
  - Left: Sprout icon + "Digital SmartSoil" text (golden)
  - Center: Navigation buttons (My Farms, History, About, How to Use, Contact)
  - Right: Profile name + User icon, Logout button
  - Mobile: Hamburger menu (BottomSheetDialog with full-width menu)

- BottomNavigationView with 4 tabs:
  - Dashboard (Home icon)
  - Soil Test (Flask icon)
  - History (Clock icon)
  - Profile (User icon)

- FragmentContainerView for fragments
```

#### Navigation Structure
- Use Android Navigation Component
- Bottom nav manages primary destinations
- Toolbar buttons for secondary navigation
- Menu-based routing for mobile

---

### 3. DASHBOARD SCREEN

#### DashboardActivity/Fragment
```
UI Layout:
- Header: "My Farms" + Welcome message (Hi, [Name]!)
- "Add Farm" FAB button (floating green)
- If no farms: Empty state
  - Leaf icon
  - Message: "No farms yet. Add your first farm!"
  - CTA button: "Add Farm"

Farm Cards Grid (2-column on tablet/desktop, 1-column on mobile):
Each card shows:
  - Farm name (large)
  - Location: Village, District (MapPin icon)
  - Current crop (if set)
  - Last soil test date
  - Weather widget (FarmWeatherComponent):
    - Temperature icon + value
    - Humidity: droplet icon + %
    - Wind: wind icon + speed
  - Action buttons: "Test" (primary), "History" (secondary)
  - 3-dot menu: Edit Farm, Delete Farm

Edit Farm Dialog:
  - Form: Name, Crop Type, City, District, Village
  - Save/Cancel buttons

Delete Farm Dialog:
  - Warning message
  - Confirm/Cancel buttons
  - Shows farm name

Functionality:
- Load farms from Supabase
- Pull-to-refresh
- Navigate to SoilTest/History based on button clicks
- Real-time weather data from Open-Meteo API
- Edit farm inline (Dialog)
- Delete with confirmation
- Error handling + retry logic
```

#### Weather Component
```
API: Open-Meteo (free, no auth required)
Endpoint: https://api.open-meteo.com/v1/forecast
Params: latitude, longitude, current=temperature,relative_humidity,wind_speed

Display:
- Temperature with weather icon
- Humidity percentage
- Wind direction + speed
- Cache data for 30 minutes
- Refresh on card touch
```

---

### 4. ADD FARM SCREEN

#### AddFarmActivity/Dialog
```
UI Elements:
- Form card with glass-card style
- Farm Name* (EditText)
- Current Crop (SelectSpinner or AutoCompleteTextView)
- City (EditText)
- District (EditText)
- Village* (EditText)
- Note: "📍 Location coordinates are auto-detected"
- Save button (green, full width)
- Cancel button

Functionality:
- Generate random lat/lng near Maharashtra:
  - Base: latitude 18.5 + random(-0.5 to 0.5)
  - Base: longitude 73.8 + random(-0.8 to 0.8)
- Validate required fields
- Save to Supabase farms table
- Show success toast
- Redirect to Dashboard
```

---

### 5. SOIL TEST SCREEN

#### SoilTestActivity/Fragment
```
Layout: Two-column (desktop/tablet), stacked (mobile)

LEFT COLUMN:
- Farm selector (Spinner/AutoComplete showing farm names)
- Image upload area:
  - Drag & drop support (or click to open photo picker)
  - Show preview with "Change" overlay button
  - Placeholder: "Select soil sample photo"
  - Dimensions: ~300x300dp
- "Predict Soil Health" button (green, FlaskConical icon)
- Loading indicator (circular with pulse animation)

RIGHT COLUMN (After prediction):
- Results header: "Soil Analysis Results"
- Parameter Cards (animated):
  Each parameter (SOC, N, P, K, pH) shows:
  - Parameter name + unit
  - Animated progress bar with status color
  - Numeric value
  - Status label (Low/Medium/High)
  - Recommendation text snippet

Status Thresholds:
  SOC:  <0.5% = Low, <1.2% = Med, ≥1.2% = High
  N:    <120 kg/ha = Low, <240 = Med, ≥240 = High
  P:    <15 kg/ha = Low, <35 = Med, ≥35 = High
  K:    <120 kg/ha = Low, <280 = Med, ≥280 = High
  pH:   <6.0 = Low, <7.5 = Med, ≥7.5 = High

- Recommended Crops section:
  - Pill badges in 2-column grid
  - Primary color for "Best", muted for "Alternative"
  - Each shows: Crop name, suitability score, icon
  
- Action buttons:
  - "Save Result" button
  - "View History" button (secondary)

Functionality:
- Image picker (camera or gallery)
- Image preview + validation
- Call ML prediction endpoint (mock for MVP):
  generateRandomPrediction():
    SOC: random(0.3, 2.3)
    N: random(50, 350)
    P: random(5, 65)
    K: random(50, 450)
    pH: random(5.0, 8.0)

- Crop recommendation logic:
  Based on values, recommend:
  - Wheat, Soybean, Rice, Sugarcane, Cotton, Jowar, Bajra
  - Score: 0.5-1.0 based on parameter suitability

- Upload image to Supabase storage bucket: "soil-images"
- Save SoilTest record to Supabase
- Animation: Grow animation for progress bars (800ms)
```

---

### 6. HISTORY SCREEN

#### HistoryActivity/Fragment
```
UI Elements:
Top section:
- Farm filter dropdown (All Farms / Specific Farm)
- "Export as PDF" button

if (tests.length >= 2):
  - Soil Trend Chart (LineChart from MPAndroidChart)
    - Show all 5 parameters over time (X: test date, Y: value)
    - Multi-line chart with color-coded lines
    - Smooth animation on load
  
Test Cards List (scrollable):
Each card shows:
  - Farm name (bold)
  - Test date (formatted: "DD MMM YYYY")
  - Key values: SOC, N, pH
  - Primary recommended crop
  - Clickable → details view

if (tests.length === 0):
  - Empty state: FlaskConical icon
  - Message: "No soil tests yet"
  - CTA: "Conduct First Test" → navigate to SoilTest

Test Detail View (click on test card):
- Full parameter grid (2x3):
    SOC    | N    | P
    K      | pH   | (empty)
  - Each cell shows value, unit, status color
- Soil image (if available) with full-width display
- All recommended crops as badges
- Show predictions date
- Back button

PDF Export:
- Click "Export PDF"
- Generate report:
  - Header: "Digital SmartSoil - Soil Health Report"
  - Farm name, test date, location
  - Table: Parameter | Value | Status | Recommendation
  - Chart image (render LineChart to bitmap)
  - Recommended crops list
  - Footer: generation date
- Save to device downloads or show share intent
```

---

### 7. PROFILE SCREEN

#### ProfileActivity/Fragment
```
UI Elements:
- Centered card:
  - Large user avatar circle (User icon, background color)
  - Edit button (pencil icon, FAB or button)

- Form fields:
  - Full Name (EditText)
  - Mobile Number (EditText with phone input type)
  - Gender (SelectSpinner: Male/Female/Other)
  - Email (TextView, read-only, from auth)

- Buttons:
  - "Save Changes" (green)
  - "Logout" (red variant)

Functionality:
- Load profile from Supabase profiles table
- Edit and save via Supabase
- Show success toast on save
- Logout: clear SessionManager + redirect to LoginActivity
- Handle read-only email field
```

---

### 8. INFORMATION SCREENS

#### AboutActivity
```
Three info cards (staggered fade-in animation):
1. Mission Card
   - Target icon
   - Title: "Our Mission"
   - Content: "Empowering Maharashtra farmers with AI-driven soil health insights"

2. Research Card
   - GraduationCap icon
   - Title: "Research-Backed"
   - Content: "Based on PhD research using MobileNetV2 CNN model trained with ICAR lab data"

3. Acknowledgments Card
   - Building2 icon
   - Title: "Collaboration"
   - Content: "Developed in partnership with agricultural research institutes in Maharashtra"

Each card: glass-card style, left icon, right text, AnimationDrawable for stagger
```

#### HowToUseActivity
```
4 Step Cards (with numbered icons):
1. Take Photo
   - Camera icon
   - "Take a clear photo of your soil sample or test tube"
   - Tips: "Natural sunlight, 15-20cm distance"

2. Upload Image
   - Upload icon
   - "Upload the photo to the app"

3. Get Predictions
   - Zap/Sparkles icon
   - "AI predicts soil parameters instantly"

4. View Recommendations
   - CheckCircle icon
   - "Get crop recommendations based on results"

Photo Tips Section (collapsible card):
- "Best Practices for Accurate Results"
- Bullet points: lighting, distance, background, angle
```

#### ContactActivity
```
UI Elements:
- Form card:
  - Name (EditText)
  - Mobile (EditText, tel input)
  - Message (EditText, multiline, 200dp height)
  - "Submit" button (green)
  - "Call Support" button (secondary, tel: link)

Functionality:
- Form validation (required fields)
- On submit: Show toast "Thank you! We'll get back to you soon"
- Call Support: Create intent to dial predefined support number
```

---

## 🔐 DATABASE SCHEMA (Supabase)

### profiles table
```sql
CREATE TABLE profiles (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  user_id UUID NOT NULL REFERENCES auth.users(id) ON DELETE CASCADE,
  name TEXT NOT NULL,
  mobile TEXT,
  gender TEXT,
  created_at TIMESTAMPTZ DEFAULT now(),
  updated_at TIMESTAMPTZ DEFAULT now()
);

-- RLS: SELECT, INSERT, UPDATE own rows (auth.uid() = user_id)
-- Trigger: Auto-create profile on auth.users insert
```

### farms table
```sql
CREATE TABLE farms (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  user_id UUID NOT NULL REFERENCES auth.users(id) ON DELETE CASCADE,
  name TEXT NOT NULL,
  village TEXT NOT NULL,
  city TEXT,
  district TEXT,
  crop_type TEXT,
  latitude DOUBLE PRECISION NOT NULL,
  longitude DOUBLE PRECISION NOT NULL,
  created_at TIMESTAMPTZ DEFAULT now(),
  updated_at TIMESTAMPTZ DEFAULT now()
);

-- RLS: SELECT, INSERT, UPDATE, DELETE own rows
```

### soil_tests table
```sql
CREATE TABLE soil_tests (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  farm_id UUID NOT NULL REFERENCES farms(id) ON DELETE CASCADE,
  user_id UUID NOT NULL REFERENCES auth.users(id) ON DELETE CASCADE,
  date TIMESTAMPTZ DEFAULT now(),
  image_url TEXT,
  soc DOUBLE PRECISION,
  nitrogen DOUBLE PRECISION,
  phosphorus DOUBLE PRECISION,
  potassium DOUBLE PRECISION,
  ph DOUBLE PRECISION,
  recommended_crops JSONB DEFAULT '[]',
  created_at TIMESTAMPTZ DEFAULT now()
);

-- RLS: SELECT, INSERT, DELETE own rows
```

### Storage: soil-images bucket
```
Bucket name: soil-images
Public: false
RLS: users can UPDATE/INSERT own files
Path: /user_id/farm_id/timestamp_filename.jpg
```

---

## 🎯 IMPLEMENTATION PHASES

### Phase 1: Setup & Auth (Week 1)
- [ ] Project setup with Gradle dependencies
- [ ] Supabase configuration (Firebase for OAuth or direct Supabase)
- [ ] AuthContext + SessionManager
- [ ] LoginActivity + RegisterActivity
- [ ] ForgotPassword + ResetPassword flows
- [ ] Auth unit tests

### Phase 2: Core UI & Navigation (Week 2)
- [ ] AppLayout (AppBarLayout + BottomNavigationView + Navigation Graph)
- [ ] Fragment structure & navigation routing
- [ ] Design system (colors, typography, glass-card components)
- [ ] MainActivity with fragment container
- [ ] Custom animated components
- [ ] Responsive layouts (mobile/tablet)

### Phase 3: Dashboard & Farm Management (Week 3)
- [ ] DashboardFragment with farm cards
- [ ] AddFarmActivity + EditFarmDialog
- [ ] DeleteFarmDialog with confirmation
- [ ] FarmWeatherComponent + Open-Meteo API
- [ ] Pull-to-refresh
- [ ] Error handling & retry logic

### Phase 4: Soil Testing Feature (Week 3-4)
- [ ] SoilTestActivity UI layout
- [ ] Image picker (camera/gallery)
- [ ] Image preview & upload to Supabase Storage
- [ ] Mock prediction engine (generate random values)
- [ ] Crop recommendation logic
- [ ] Animated progress bars for parameters
- [ ] Save SoilTest to Supabase

### Phase 5: History & Charts (Week 4)
- [ ] HistoryActivity with test list
- [ ] Farm filter dropdown
- [ ] MPAndroidChart integration (LineChart)
- [ ] Test detail view
- [ ] PDF generation (iTextPDF or Android Print Framework)
- [ ] Empty states & loading states

### Phase 6: Profile & Info Pages (Week 5)
- [ ] ProfileActivity with edit form
- [ ] AboutActivity with info cards
- [ ] HowToUseActivity with steps
- [ ] ContactActivity with form
- [ ] Logout functionality
- [ ] Session management

### Phase 7: Polish & Testing (Week 5)
- [ ] Animation implementation (fade-in, scale-in, slide-up, grow)
- [ ] Dark mode support
- [ ] Error handling & validation
- [ ] Unit tests + instrumented tests
- [ ] Performance optimization
- [ ] UI/UX polish

### Phase 8: ML Integration & Deployment (Week 6+)
- [ ] Integrate actual ML model (TensorFlow Lite or API)
- [ ] Replace mock predictions
- [ ] Production Supabase setup
- [ ] Google Play Store preparation
- [ ] Beta testing

---

## 📦 GRADLE DEPENDENCIES

```gradle
dependencies {
    // Core AndroidX
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'androidx.core:core:1.12.0'
    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.7.0'
    
    // Material Design 3
    implementation 'com.google.android.material:material:1.11.0'
    
    // Navigation
    implementation 'androidx.navigation:navigation-fragment:2.7.7'
    implementation 'androidx.navigation:navigation-ui:2.7.7'
    
    // LiveData & ViewModel
    implementation 'androidx.lifecycle:lifecycle-viewmodel:2.7.0'
    implementation 'androidx.lifecycle:lifecycle-livedata:2.7.0'
    
    // Fragments
    implementation 'androidx.fragment:fragment:1.6.2'
    
    // Networking
    implementation 'com.squareup.retrofit2:retrofit:2.11.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.11.0'
    implementation 'com.squareup.okhttp3:okhttp:4.12.0'
    implementation 'com.squareup.okhttp3:logging-interceptor:4.12.0'
    
    // Supabase (if using client library)
    implementation 'io.github.supabase:postgrest-kt:2.0.0'
    implementation 'io.github.supabase:auth-kt:2.0.0'
    implementation 'io.github.supabase:storage-kt:2.0.0'
    
    // Firebase (for Google OAuth)
    implementation 'com.google.firebase:firebase-auth:22.3.1'
    implementation 'com.google.android.gms:play-services-auth:20.7.0'
    
    // Image Loading
    implementation 'com.github.bumptech.glide:glide:4.16.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.16.0'
    
    // Charts
    implementation 'com.github.PhilJay:MPAndroidChart:v3.1.0'
    
    // PDF Generation
    implementation 'com.itextpdf:itextpdf:5.5.13.3'
    
    // JSON
    implementation 'com.google.code.gson:gson:2.10.1'
    
    // Room (local database)
    implementation 'androidx.room:room-runtime:2.6.1'
    annotationProcessor 'androidx.room:room-compiler:2.6.1'
    
    // Location Services
    implementation 'com.google.android.gms:play-services-location:21.1.0'
    
    // Coroutines
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3'
    
    // Testing
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
    
    // Logging
    implementation 'timber:timber:5.0.1'
}
```

---

## 🔧 KEY UTILITIES

### Constants.java
```java
public class Constants {
    public static final String SUPABASE_URL = "https://your-project.supabase.co";
    public static final String SUPABASE_ANON_KEY = "your-anon-key";
    public static final String WEATHER_API_URL = "https://api.open-meteo.com/v1";
    
    // Database tables
    public static final String TABLE_PROFILES = "profiles";
    public static final String TABLE_FARMS = "farms";
    public static final String TABLE_SOIL_TESTS = "soil_tests";
    
    // Storage buckets
    public static final String BUCKET_SOIL_IMAGES = "soil-images";
    
    // Status thresholds
    public static final double SOC_LOW_THRESHOLD = 0.5;
    public static final double SOC_MED_THRESHOLD = 1.2;
    // ... other thresholds
    
    // Maharashtra coordinates (for random farm location generation)
    public static final double MH_BASE_LATITUDE = 18.5;
    public static final double MH_BASE_LONGITUDE = 73.8;
}
```

### SoilPredictionEngine.java
```java
public class SoilPredictionEngine {
    public static SoilTestResult generatePrediction(File imageFile) {
        // MVP: Generate random predictions
        // Future: Integrate TensorFlow Lite model or API
        
        return new SoilTestResult(
            soc: random(0.3, 2.3),
            nitrogen: random(50, 350),
            phosphorus: random(5, 65),
            potassium: random(50, 450),
            ph: random(5.0, 8.0)
        );
    }
}
```

### CropRecommendationEngine.java
```java
public class CropRecommendationEngine {
    public static List<CropRecommendation> recommendCrops(SoilTestResult result) {
        List<String> CROPS = {"Wheat", "Soybean", "Rice", "Sugarcane", "Cotton", "Jowar", "Bajra"};
        
        // Logic: Score each crop based on soil parameters
        List<CropRecommendation> recommendations = new ArrayList<>();
        for (String crop : CROPS) {
            double score = calculateCompatibility(crop, result);
            recommendations.add(new CropRecommendation(crop, score));
        }
        
        return recommendations.stream()
            .sorted((a, b) -> Double.compare(b.score, a.score))
            .limit(5)
            .collect(Collectors.toList());
    }
}
```

### StatusColorHelper.java
```java
public class StatusColorHelper {
    public static int getStatusColor(String parameter, double value) {
        if (parameter.equals("SOC")) {
            if (value < 0.5) return Color.RED;
            if (value < 1.2) return Color.YELLOW;
            return Color.GREEN;
        }
        // ... other parameters
        return Color.GRAY;
    }
    
    public static String getStatusLabel(String parameter, double value) {
        // Returns "Low", "Medium", or "High"
    }
}
```

### PdfGenerator.java
```java
public class PdfGenerator {
    public static File generateReport(List<SoilTest> tests, Farm farm) {
        // Use iTextPDF to create PDF document
        Document document = new Document();
        
        // Add header with gradient (convert to image)
        // Add farm info table
        // Add soil test table
        // Add chart image (render LineChart to bitmap)
        // Add recommended crops
        // Add footer
        
        return savedFile;
    }
}
```

---

## 🎬 ANIMATION STRATEGIES

### Fade-In Animation
```xml
<!-- res/anim/fade_in.xml -->
<set xmlns:android="http://schemas.android.com/apk/res/android">
    <alpha
        android:fromAlpha="0.0"
        android:toAlpha="1.0"
        android:duration="300" />
</set>
```

### Scale-In Animation
```xml
<!-- res/anim/scale_in.xml -->
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:startOffset="100">
    <scale
        android:fromXScale="0.8"
        android:fromYScale="0.8"
        android:toXScale="1.0"
        android:toYScale="1.0"
        android:pivotX="50%"
        android:pivotY="50%"
        android:duration="300" />
</set>
```

### Grow Animation (for progress bars)
```xml
<!-- res/anim/grow_progress.xml -->
<set xmlns:android="http://schemas.android.com/apk/res/android">
    <scaleX
        android:fromXScale="0.0"
        android:toXScale="1.0"
        android:pivotX="0%"
        android:duration="800"
        android:interpolator="@android:interpolator/accelerate_decelerate" />
</set>
```

### Slide-Up Animation
```xml
<!-- res/anim/slide_up.xml -->
<set xmlns:android="http://schemas.android.com/apk/res/android">
    <translate
        android:fromYDelta="100%"
        android:toYDelta="0%"
        android:duration="400" />
</set>
```

### Stagger Animation (RecyclerView items)
```java
// In adapter onBindViewHolder:
container.setAlpha(0f);
container.animate()
    .alpha(1f)
    .setDuration(300)
    .setStartDelay(position * 80) // 80ms stagger
    .start();
```

---

## 📱 RESPONSIVE DESIGN STRATEGY

### Configuration Qualifiers
```
res/layout/             # Phone (< 600dp)
res/layout-sw600dp/     # Tablet 7" (600-719dp)
res/layout-sw720dp/     # Tablet 10" (720dp+)

colors (all devices)
themes (variants for night mode)
dimens (different sizes per configuration)
```

### Key Responsive Layouts
- Dashboard: 1-column phone, 2-column tablet
- Soil Test: stacked phone, 2-column tablet
- Toolbar: hamburger menu on phone, visible buttons on tablet
- Bottom Nav: always visible or collapsible on tablet

---

## 🚀 ROLLOUT STRATEGY

1. **MVP Phase** (use mock predictions)
2. **Beta Release** (closed beta on Firebase Test Lab + select devices)
3. **ML Integration** (after model training complete)
4. **Production Release** (Google Play Store)
5. **Marketing** (target Maharashtra farmer communities, agricultural organizations)

---

## 📝 TESTING CHECKLIST

- [ ] Unit tests for ViewModels
- [ ] Unit tests for Repositories + API
- [ ] Instrumented tests for Activities
- [ ] Navigation tests
- [ ] Database tests (Room + Supabase)
- [ ] API error handling tests
- [ ] Image upload tests
- [ ] PDF generation tests
- [ ] UI tests (Espresso)

---

**Next Steps:**
1. Review this plan with the team
2. Set up Android Studio project with Gradle dependencies
3. Create GitHub branch for development
4. Start Phase 1 (Auth implementation)
5. Weekly check-ins on progress
