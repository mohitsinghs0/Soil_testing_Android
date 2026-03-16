# SmartSoil - Digital Soil Testing Application

A comprehensive Android application for digital soil testing, farm management, and crop recommendations powered by Supabase and Open-Meteo weather API.

## Project Overview

SmartSoil is a modern Android application that helps farmers conduct soil tests, manage farms, and receive data-driven crop recommendations. The app uses Supabase for backend services and integrates with Open-Meteo for real-time weather data.

## Features

### 📱 Core Features
- **User Authentication**: Secure login and registration with Supabase
- **Farm Management**: Add, edit, and manage multiple farms
- **Soil Testing**: Record soil parameters (Nitrogen, Phosphorus, Potassium, pH, Organic Matter, Moisture)
- **Weather Integration**: Real-time weather data for each farm location
- **Crop Recommendations**: AI-powered crop suggestions based on soil analysis
- **Test History**: View historical soil test results with detailed analysis
- **PDF Reports**: Generate and export soil test reports as PDF

### 🎨 UI/UX Features
- Modern Material Design interface with glass morphism elements
- Dark mode support
- Smooth animations and transitions
- Responsive layouts for various screen sizes

## Project Structure

```
app/src/main/
├── java/com/digitalsmartsoil/app/
│   ├── activities/           # All app activities
│   ├── fragments/            # Fragment components
│   ├── adapters/             # RecyclerView adapters
│   ├── models/               # Data models
│   ├── api/                  # API interfaces (Retrofit)
│   ├── repository/           # Data repositories
│   ├── viewmodels/           # MVVM ViewModels
│   ├── utils/                # Utility classes
│   └── ui/                   # Custom UI components
│
└── res/
    ├── layout/               # XML layout files
    ├── drawable/             # Vector drawables and shapes
    ├── values/               # Colors, strings, themes, dimensions
    ├── values-night/         # Dark theme resources
    ├── anim/                 # Animation definitions
    ├── menu/                 # Menu definitions
    ├── navigation/           # Navigation graph
    └── font/                 # Custom fonts
```

## Key Components

### Activities (13 Total)
1. **SplashActivity** - Splash screen with 2-second delay
2. **LoginActivity** - User login screen
3. **RegisterActivity** - User registration screen
4. **ForgotPasswordActivity** - Password reset request
5. **ResetPasswordActivity** - Password reset completion
6. **MainActivity** - Main app with bottom navigation
7. **AddFarmActivity** - Add new farm
8. **SoilTestActivity** - Record soil test data
9. **HistoryActivity** - View test history
10. **ProfileActivity** - User profile management
11. **AboutActivity** - App information
12. **HowToUseActivity** - Usage guide
13. **ContactActivity** - Contact support

### Fragments (4 Total)
1. **DashboardFragment** - Overview and farm list
2. **SoilTestFragment** - Soil testing interface
3. **HistoryFragment** - Test history list
4. **ProfileFragment** - User profile editor

### Models (7 Total)
- **User** - User account information
- **Profile** - User profile details
- **Farm** - Farm information and location
- **SoilTest** - Soil test records
- **SoilResult** - Individual soil parameters
- **WeatherData** - Weather information
- **CropRecommendation** - Crop recommendations

### API Integration
- **SupabaseClient** - Retrofit instance management
- **SupabaseAuthApi** - Authentication endpoints
- **SupabaseDbApi** - Database CRUD endpoints
- **SupabaseStorageApi** - File storage endpoints
- **WeatherApi** - Open-Meteo weather endpoints

### Data Repositories
- **AuthRepository** - Authentication operations
- **FarmRepository** - Farm data operations
- **SoilTestRepository** - Soil test operations
- **ProfileRepository** - User profile operations

### ViewModels (5 Total)
- **AuthViewModel** - Authentication logic
- **DashboardViewModel** - Dashboard data management
- **SoilTestViewModel** - Soil test operations
- **HistoryViewModel** - Test history management
- **ProfileViewModel** - Profile management

### Utility Classes
- **Constants** - API endpoints and configuration
- **SessionManager** - SharedPreferences management
- **SoilPredictor** - Soil analysis logic
- **CropRecommender** - Crop recommendation engine
- **StatusColorHelper** - UI status colors
- **ImageUtils** - Image processing utilities
- **PdfExporter** - PDF report generation

### Custom UI Components
- **CustomProgressBar** - Animated progress indicators
- **WeatherCardView** - Weather display widget
- **GlassCardView** - Glass morphism card component

## Dependencies

### Core AndroidX
- androidx.core:core-ktx
- androidx.appcompat:appcompat
- androidx.lifecycle:lifecycle-viewmodel
- androidx.lifecycle:lifecycle-livedata

### Networking
- retrofit2:retrofit
- retrofit2:converter-gson
- okhttp3:okhttp
- okhttp3:logging-interceptor

### UI Components
- com.google.android.material:material
- androidx.fragment:fragment
- androidx.navigation:navigation-fragment
- androidx.recyclerview:recyclerview
- androidx.cardview:cardview

### Utilities
- google.code.gson:gson
- com.itextpdf:itextpdf (PDF generation)
- androidx.security:security-crypto
- com.google.android.gms:play-services-location

## Getting Started

### Prerequisites
- Android Studio (Arctic Fox or later)
- Java 11 or higher
- Android SDK 24+

### Setup Instructions

1. **Clone the repository** or extract the project files

2. **Configure Supabase**:
   - Update `Constants.SUPABASE_URL` with your Supabase project URL
   - Update `Constants.SUPABASE_ANON_KEY` with your Supabase anonymous key

3. **Sync Gradle**:
   ```bash
   ./gradlew build
   ```

4. **Run the application**:
   - Select a device or emulator
   - Click "Run" or press Shift + F10

## Configuration

### Supabase Setup
Update the following in `Constants.java`:
```java
public static final String SUPABASE_URL = "https://your-project.supabase.co";
public static final String SUPABASE_ANON_KEY = "your-anon-key-here";
```

### Database Tables Required
- `users` - User accounts
- `profiles` - User profiles
- `farms` - Farm information
- `soil_tests` - Soil test records
- `soil_results` - Individual test results
- `weather_data` - Weather information

## API Integration

### Authentication Flow
1. User registers/logs in
2. Supabase returns JWT token
3. SessionManager stores token in SharedPreferences
4. Token used for subsequent API calls

### Data Flow
1. UI Layer (Activities/Fragments)
2. ViewModel Layer (Data processing)
3. Repository Layer (Data operations)
4. API Layer (Network calls via Retrofit)
5. Supabase Backend

## Design System

### Colors
- **Primary Green**: #2D5016
- **Primary Gold**: #D4AF37
- **Primary Light Green**: #4CAF50
- **Status Low (Red)**: #FF6B6B
- **Status Medium (Orange)**: #FFA500
- **Status High (Green)**: #4CAF50

### Typography
- **Font**: Outfit (Regular, Bold) and DM Sans (Regular, Medium)
- **Sizes**: 12sp (small) to 24sp (extra large)

### Spacing
- Extra Small: 4dp
- Small: 8dp
- Medium: 16dp
- Large: 24dp
- Extra Large: 32dp

### Corner Radius
- Small: 4dp
- Medium: 8dp
- Large: 12dp
- Extra Large: 16dp

## Permissions

The app requires the following permissions:
- `INTERNET` - Network communication
- `ACCESS_NETWORK_STATE` - Network status
- `ACCESS_FINE_LOCATION` - GPS coordinates
- `ACCESS_COARSE_LOCATION` - Approximate location
- `CAMERA` - Soil photo capture
- `READ_EXTERNAL_STORAGE` - Image access
- `WRITE_EXTERNAL_STORAGE` - File export

## Testing

### Unit Tests
Located in `app/src/test/java/`

### Instrumented Tests
Located in `app/src/androidTest/java/`

Run tests with:
```bash
./gradlew test                    # Unit tests
./gradlew connectedAndroidTest   # Instrumented tests
```

## Build & Release

### Debug Build
```bash
./gradlew assembleDebug
```

### Release Build
```bash
./gradlew assembleRelease
```

## Architecture

The app follows the **MVVM (Model-View-ViewModel)** architecture pattern:

- **View Layer**: Activities and Fragments
- **ViewModel Layer**: Manages UI data and logic
- **Repository Layer**: Abstracts data sources
- **API Layer**: Handles network communication
- **Model Layer**: Data classes

## Best Practices

1. **Data Binding**: Use LiveData for reactive updates
2. **Error Handling**: Implement proper exception handling
3. **Networking**: Use interceptors for token injection
4. **UI Responsiveness**: Execute network calls on background threads
5. **Memory Management**: Clean up resources in onDestroy()
6. **Security**: Store sensitive data securely using EncryptedSharedPreferences

## Known Limitations

- PDF export requires iTextPDF library
- Weather data depends on internet connectivity
- Location services require device permissions
- Soil prediction is based on mock data (requires ML model integration)

## Future Enhancements

- [ ] Machine learning model for soil prediction
- [ ] Offline data storage with Room database
- [ ] Advanced analytics and charts
- [ ] Notification system for soil alerts
- [ ] Multi-language support
- [ ] User community and knowledge sharing
- [ ] IoT sensor integration
- [ ] Crop disease detection

## Support & Documentation

For detailed documentation on specific components, refer to:
- Supabase Docs: https://supabase.io/docs
- Retrofit: https://square.github.io/retrofit/
- Material Design: https://material.io/design
- Open-Meteo: https://open-meteo.com/en/docs

## License

[Add your license information here]

## Contributors

- Development Team: SmartSoil Team

## Version History

### v1.0 (Current)
- Initial release with core features
- User authentication
- Farm management
- Soil testing
- Crop recommendations
- Weather integration

---

**Last Updated**: March 17, 2026
**Status**: Production Ready
