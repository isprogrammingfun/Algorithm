class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        String[] videoInfo = video_len.split(":");
        String[] positionInfo = pos.split(":");
        String[] openingStartInfo = op_start.split(":");
        String[] openingEndInfo = op_end.split(":");
        
        int videoSeconds = Integer.parseInt(videoInfo[0]) * 60 + Integer.parseInt(videoInfo[1]);
        int positionSeconds = Integer.parseInt(positionInfo[0]) * 60 + Integer.parseInt(positionInfo[1]);
        int openingStartSeconds = Integer.parseInt(openingStartInfo[0]) * 60 + Integer.parseInt(openingStartInfo[1]);
        int openingEndSeconds = Integer.parseInt(openingEndInfo[0]) * 60 + Integer.parseInt(openingEndInfo[1]);
        
        for (int i = 0; i < commands.length; i++) {
            if(openingStartSeconds <= positionSeconds && positionSeconds <= openingEndSeconds)
                positionSeconds = openingEndSeconds;
            if(commands[i].equals("prev")) {
                if(positionSeconds <= 10)
                    positionSeconds = 0;
                else 
                    positionSeconds -= 10;
            }
            else {
                if(videoSeconds - positionSeconds < 10)
                    positionSeconds = videoSeconds;
                else
                    positionSeconds += 10;                
            }
            
        }
        if(openingStartSeconds <= positionSeconds && positionSeconds <= openingEndSeconds)
            positionSeconds = openingEndSeconds;
        
        answer = String.format("%02d:%02d", positionSeconds / 60, positionSeconds % 60);
        return answer;
    }
}