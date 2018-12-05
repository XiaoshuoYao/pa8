import sound.*;

class Sound{
  private final int[] samples;

  Sound(int[] samples){
    this.samples = samples;
  }

  public int getNumSamples(){
    return samples.length;
  }

  public int getSample(int index){
    return this.samples[index];
  }

  public int[] getSamples(){
    return this.samples;
  }

  public String toString(){
    int length = samples.length;
    String samplesRef = this.samples.toString();
    String ref = samplesRef.substring(samplesRef.indexOf("@"));
    return "Sound[samples=["+ length +"]"+ ref +"]";
  }

  public static Sound crop(Sound original, int start, int end){
    int size = end - start ;
    int[] newSound = new int[size];
    for(int i = 0; i < size; i += 1){
      newSound[i] = original.getSample(i + start);
    }
    return new Sound(newSound);
  }

  public static Sound mix(Sound background, Sound foreground, int index){
    int size = background.getNumSamples();
    int[] newSound = new int[size];
    for(int i = 0; i < size; i += 1){
      if (i < index) {
        newSound[i] = background.getSample(i);
      }
      else {
        newSound[i] = background.getSample(i) + foreground.getSample(i);
      }
    }
    return new Sound(newSound);
  }
}
