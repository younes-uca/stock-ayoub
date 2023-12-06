import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {PersonneDto} from 'src/app/controller/model/commun/Personne.model';
import {PersonneCriteria} from 'src/app/controller/criteria/commun/PersonneCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class PersonneAdminService extends AbstractService<PersonneDto, PersonneCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/personne/');
    }

    public constrcutDto(): PersonneDto {
        return new PersonneDto();
    }

    public constrcutCriteria(): PersonneCriteria {
        return new PersonneCriteria();
    }
}
