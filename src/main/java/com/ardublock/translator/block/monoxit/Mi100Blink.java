package com.ardublock.translator.block.monoxit;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
//import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;
	
public class Mi100Blink extends TranslatorBlock
{

	public Mi100Blink(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
				
    TranslatorBlock tbRedDutyBlock = this.getRequiredTranslatorBlockAtSocket(0);
		String redDuty = tbRedDutyBlock.toCode();
    
    TranslatorBlock tbGreenDutyBlock = this.getRequiredTranslatorBlockAtSocket(1);
		String greenDuty = tbGreenDutyBlock.toCode();
    
    TranslatorBlock tbBlueDutyBlock = this.getRequiredTranslatorBlockAtSocket(2);
		String blueDuty = tbBlueDutyBlock.toCode();
    
    TranslatorBlock tbDurationBlock = this.getRequiredTranslatorBlockAtSocket(3);
		String duration = tbDurationBlock.toCode();
		
		if (Integer.parseInt(duration) > 1000 ) 
		{
			//throw new BlockException(this.blockId, "the duration must not be over 1000");
			//duration = "1000";
		}
		
    String instanceName = "ROBO";
    
    String ret = "\t" + instanceName + ".blink(" + redDuty + ", " + greenDuty + ", " + blueDuty + ", " + duration + ");\n";
    
		translator.addHeaderFile("MI100lib.h");
		translator.addDefinitionCommand("MI100 " + instanceName + ";");
		//translator.addSetupCommand(instanceName + ".setDefaultSpeed(" + speed + ");");

		return ret;
		}

	}
