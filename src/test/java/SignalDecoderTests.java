import org.junit.Assert;
import org.junit.Test;

public class SignalDecoderTests {

    @Test
    public void correctOutputTest() {
        SignalDecoder decoder = new SignalDecoder("input2.txt");
        decoder.decodeSignal();
        Assert.assertEquals("easter", decoder.getDecodedSignal());
    }

    @Test
    public void bigInputTest() {
        SignalDecoder decoder = new SignalDecoder("input.txt");
        decoder.decodeSignal();
        Assert.assertEquals("umcvzsmw", decoder.getDecodedSignal());
    }

}