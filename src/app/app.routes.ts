import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AuthGuard } from './Guards/auth.guard';
import { UserComponent } from './Dashboard/user.component';

export const routes: Routes = [
             { path: 'login', component: LoginComponent },
             { path: 'register', component: RegisterComponent},
             { path: 'Guards', component: AuthGuard},
             { path: 'Dashboard', component: UserComponent},
             { path: '', redirectTo: '/login', pathMatch: 'full' },   // default route
             { path: '**', redirectTo: '/login' }                     // wildcard (invalid URLs)
];
