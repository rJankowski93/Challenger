import {Component, Input} from "@angular/core";

@Component({
    moduleId: module.id,
    selector: 'video-player',
    templateUrl: './video-player.component.html'
})
export class VideoPlayerComponent {
    // doc: https://videogular.github.io/videogular2/getting-started/

    @Input() videoWidth:number;
    @Input() videoHeight:number;
}