package filesprocessing.filters;
import java.io.File;

public class WritableFilter extends FileFeaturesFilter{
	private boolean answer;
	public WritableFilter(boolean answer) {this.answer=answer;}

	@Override
	public boolean isPassFilter(File file) {
		return file.canWrite()==answer;
	}
}
