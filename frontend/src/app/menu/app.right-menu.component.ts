import {Component} from '@angular/core';
import {AppMainComponent} from 'src/app/template/app.main.component';

@Component({
    selector: 'app-right-menu',
    templateUrl: './app.right-menu.component.html'
})
export class AppRightMenuComponent {
    statusActive = true;

    messagesActive: boolean;

    constructor(public appMain: AppMainComponent) {
    }

    messagesClick() {
        this.statusActive = false;
        this.messagesActive = true;
    }

    statusClick() {
        this.statusActive = true;
        this.messagesActive = false;
    }
}
