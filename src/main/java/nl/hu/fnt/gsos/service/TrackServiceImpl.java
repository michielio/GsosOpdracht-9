package nl.hu.fnt.gsos.service;

import java.util.ArrayList;
import java.util.List;

public class TrackServiceImpl {
    private List<Track> tracks = new ArrayList<Track>();
    public String trackListString = "" ;
    public int trackListCount = 0 ;

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
        this.buildTrackListInformation() ;
    }



    public TrackServiceImpl() {
        this.addNewTrack(new Track(1, "The Doors", "Light My Fire", 1967,
                "www.youtube.com/watch?v=M_yWyBjDEaU"));

        this.addNewTrack(new Track(2, "Rolling Stones", "Angie", 1974,
                "www.youtube.com/watch?v=RcZn2-bGXqQ"));

        this.addNewTrack(new Track(3, "Kraftwerk", "The model", 1978,
                "www.youtube.com/watch?v=BdZDhpkDziE"));

        this.addNewTrack(new Track(4, "Pixies", "Monkey Gone to Heaven", 1989,
                "www.youtube.com/watch?v=mK3iSglbZUM"));

        this.addNewTrack(new Track(5, "St germain", "Rose Rouge", 2000,
                "https://www.youtube.com/watch?v=yRpKKBmeqV4"));

        this.addNewTrack(new Track(6, "Lilly Wood & The Prick",
                "Prayer In C (Robin Schulz Remix)", 2014,
                "https://www.youtube.com/watch?v=fiore9Z5iUg"));
    }

    public boolean addNewTrack(Track track){
        boolean trackAdded = false ;
        if(track != null) {
            tracks.add(track);
            trackListString = trackListString + "\n" + track.toString();
            trackListCount++;
            trackAdded = true ;
        }
        return trackAdded ;
    }


    public Track getTrackById(int id) {
        for (Track track : tracks) {
            if (track.getId() == id) {
                return track;
            }
        }
        return null;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public boolean remove(int id) {
        Track trackToRemove = findTrack(id) ;
        boolean isTrackRemoved = tracks.remove(trackToRemove) ;

        this.rebuildTrackListString() ;
        trackListCount-- ;

        return isTrackRemoved ;
    }

    private void buildTrackListInformation(){
        trackListString = "" ;
        for (Track trck : tracks) {
            trackListString = trackListString + "\n" + trck.toString() ;
            trackListCount++ ;
        }
    }

    private void rebuildTrackListString() {
        trackListString = "" ;
        for (Track trck : tracks) {
            trackListString = trackListString + "\n" + trck.toString() ;
        }
    }

    private Track findTrack(int id) {
        for (Track track : tracks) {
            if (track.getId() == id) {
                return track;
            }

        }
        return null;
    }

}
