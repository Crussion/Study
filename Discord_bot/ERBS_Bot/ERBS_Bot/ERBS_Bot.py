import discord, requests
from Data import *

class ERBS(discord.Client):

    async def on_ready(self):
        print('Logged on as', self.user)
        await self.get_channel(857109283790520352).send('```' + "봇이 켜졌습니다." + '```')

    async def on_message(self, message):
        # don't respond to ourselves
        if message.author == self.user:
            return

        if message.content.lower().startswith('!nomal') | (message.content.split(' ')[0].lower() == '!n'):
            print('normal')
            await self.game_list(message, 'n')

        if message.content.lower().startswith('!rank') | (message.content.split(' ')[0].lower() == '!r'):
            print('rank')
            await self.game_list(message, 'r')

        if (message.content.lower().startswith('!status') | (message.content.split(' ')[0].lower() == '!s')):
            print('status')
            try:
                if(message.content.split(' ')[1].lower() == 'h'):
                    await message.channel.send('```!status / !s NickName TeamMode(solo, duo, trio / 1, 2, 3)```')
                    return
                nickname = message.content.split(' ')[1]
            except:
                await message.channel.send('```닉네임을 입력해 주세요.```')
                return
            try:
                teamMod = message.content.split(' ')[2]
                if((teamMod == 'solo') | (teamMod == 'duo') | (teamMod == 'trio') | (teamMod == '1') | (teamMod == '2') | (teamMod == '3')):
                    pass
                else:
                    await message.channel.send('```모드를 입력해 주세요.(solo, duo, trio / 1, 2, 3)```')
                    return
            except:
                await message.channel.send('```모드를 입력해 주세요.(solo, duo, trio / 1, 2, 3)```')
                return
            wait_message = await message.channel.send('```Wait a second...```')
            data = Data(nickname)
            print("code: ", data.code)
            if(data.code == 404):
                await wait_message.delete()
                await message.channel.send('```존재하지 않는 닉네임입니다.```')
                return
            embed=discord.Embed(title="Crussion", description="솔로")
            embed.set_thumbnail(url="https://github.com/Crussion/Study/blob/main/Discord_bot/ERBS_Bot/ERBS_Bot/res/Character_icon/03.%20Hyunwoo%20-%20%ED%98%84%EC%9A%B0.png?raw=true")
            await wait_message.delete()
            await message.channel.send(embed=embed)


    async def game_list(self, msg, mode = 'n'):
        try:
            if(msg.content.split(' ')[1].lower() == 'h'):
                await msg.channel.send('```!normal(rank)/!n(r) NickName TeamMode(solo, duo, trio / 1, 2, 3)```')
                return
            nickname = msg.content.split(' ')[1]
        except:
            await msg.channel.send('```닉네임을 입력해 주세요.```')
            return
        try:
            teamMod = msg.content.split(' ')[2]
            if((teamMod == 'solo') | (teamMod == 'duo') | (teamMod == 'trio') | (teamMod == '1') | (teamMod == '2') | (teamMod == '3')):
                pass
            else:
                await msg.channel.send('```모드를 입력해 주세요.(solo, duo, trio / 1, 2, 3)```')
                return
        except:
            await msg.channel.send('```모드를 입력해 주세요.(solo, duo, trio / 1, 2, 3)```')
            return
        wait_message = await msg.channel.send('```Wait a second...```')
        data = Data(nickname)
        print("code: ", data.code)
        if(data.code == 404):
            await wait_message.delete()
            await msg.channel.send('```존재하지 않는 닉네임입니다.```')
            return
        if(mode == 'n'): id_list = data.get_Normal_Game(teamMod)
        elif(mode == 'r'): id_list = data.get_Rank_Game(teamMod)
        else: id_list = data.get_Normal_Game(teamMod)
        s = ''
        if(len(id_list) != 0):
            for n in id_list:
                s = s + str(n) + '\n'
        else:
            s = '매치가 존재하지 않습니다.'
        await wait_message.delete()
        await msg.channel.send(s)

client = ERBS()
data = Data()

torken = data.Discord_torken
client.run(torken)
